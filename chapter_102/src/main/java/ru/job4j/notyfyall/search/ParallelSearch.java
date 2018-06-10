package ru.job4j.notyfyall.search;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
/**
 * Class ru.job4j.notyfyall.search.
 *
 * @author edzabarov
 * @since 31.05.2018
 */


@ThreadSafe
public class ParallelSearch {
    private final String root;
    private final String text;
    private final List<String> exts;
    private volatile boolean finish = false;

    private final Object lock = new Object();

    @GuardedBy("this")
    private final Queue<String> files = new ConcurrentLinkedQueue<>();

    @GuardedBy("this")
    private final Queue<String> paths = new ConcurrentLinkedQueue<>();


    public ParallelSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
    }

    public void init() {
        Thread search = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Files.walkFileTree(Paths.get(root), new SearchFileVisor());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finish = true;
                synchronized (lock) {
                    lock.notifyAll();
                }
            }
        };
        Thread read = new Thread() {
            @Override
            public void run() {
                super.run();
                while (!(files.isEmpty() && finish)) {
                    if (files.isEmpty()) {
                        try {
                            synchronized (lock) {
                                lock.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        String path = files.poll();
                        try {

                            if (Files.lines(Paths.get(path)).anyMatch(el -> el.contains(text))) paths.add(path);
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println(path);
                        }
                    }
                }
            }
        };
        search.start();
        read.start();
        try {
            search.join();
            read.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized Queue<String>  result() {
        init();
        return this.paths;
    }

    private class SearchFileVisor implements FileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            String fullName = file.getFileName().toString();
            int temp = fullName.lastIndexOf(".");
            String ext;
            ext = (temp == -1) ? "" : fullName.substring(temp + 1);
            if (exts.contains(ext)) {
                files.add(file.toString());
                synchronized (lock) {
                    lock.notifyAll();
                }
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }
    }
}


