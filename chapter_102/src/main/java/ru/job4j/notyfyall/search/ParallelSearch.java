package ru.job4j.notyfyall.search;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

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

    @GuardedBy("this")
    private final Queue<String> files = new LinkedList<>();

    @GuardedBy("this")
    private final Queue<String> paths = new LinkedList<>();


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
                notifyAll();
            }
        };
        Thread read = new Thread() {
            @Override
            public void run() {
                super.run();
                File file = null;
                while (!finish) {
                    if (files.isEmpty()) {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        synchronized (files) {
                            file = new File(files.poll());
                        }
                        //if (file == null) continue;
                        try {
                            Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(file)));
                            while (scanner.hasNextLine()) {
                                if (scanner.nextLine().contains(text)) {
                                    synchronized (paths) {
                                        paths.add(file.getAbsolutePath());
                                        break;
                                    }
                                }
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
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
            String ext = fullName.substring(temp + 1);
            if (!ext.isEmpty() && exts.contains(ext)) {
                synchronized (files) {
                    files.add(file.toString());
                    notifyAll();
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


