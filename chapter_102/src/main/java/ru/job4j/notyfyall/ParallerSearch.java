package ru.job4j.notyfyall;

import net.jcip.annotations.*;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/**
 * Class ru.job4j.notyfyall.
 *
 * @author edzabarov
 * @since 26.03.2018
 */
@ThreadSafe
public class ParallerSearch {
    private String root;
    private String text;
    private List<String> exts;

    @GuardedBy("this")
    private final Queue<String> files = new LinkedList<>();
    @GuardedBy("this")
    private final List<String> paths = new ArrayList<>();

    public ParallerSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
    }

    private void init() {
        Thread search = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Files.walkFileTree(Paths.get(root), new SearchFileVisor());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };


        Thread read = new Thread() {
            @Override
            public void run() {
                while (files.isEmpty() || search.isAlive()) {
                    String pathFile;
                    synchronized (files) {
                        pathFile = files.poll();
                        if (pathFile == null) continue;
                    }
                    try {
                        Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(new File(pathFile))));
                        while (scanner.hasNextLine()) {
                            if (scanner.nextLine().contains(text)) {
                                paths.add(pathFile);
                                break;
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                super.run();
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

    public List<String> result() {
        init();
        return paths;
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
