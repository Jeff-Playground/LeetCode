package com.wen.TwelfthFifty;

/*

Design an in-memory file system to simulate the following functions:

ls: Given a path in string format. If it is a file path, return a list that only contains this file's name. If it is a
directory path, return the list of file and directory names in this directory. Your output (file and directory names
together) should in lexicographic order.

mkdir: Given a directory path that does not exist, you should make a new directory according to the path. If the middle
directories in the path don't exist either, you should create them as well. This function has void return type.

addContentToFile: Given a file path and file content in string format. If the file doesn't exist, you need to create that
file containing given content. If the file already exists, you need to append given content to original content. This
function has void return type.

readContentFromFile: Given a file path, return its content in string format.

Example:

Input:
["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
[[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
Output:
[null,[],null,null,["a"],"hello"]


Note:

You can assume all file or directory paths are absolute paths which begin with / and do not end with /except that the
path is just "/".
You can assume that all operations will be passed valid parameters and users will not attempt to retrieve file content or
list a directory or file that does not exist.
You can assume that all directory names and file names only contain lower-case letters, and same names won't exist in the
same directory.

 */

import java.util.*;

public class LQDesignInMemoryFileSystem {
    public class FileSystem {
        Map<String, Set<String>> dirs;
        Map<String, String> files;

        public FileSystem(){
            dirs=new HashMap<>();
            files=new HashMap<>();
        }

        public List<String> ls(String path){
            if(files.containsKey(path)){
                int idx=path.lastIndexOf("/");
                return Arrays.asList(path.substring(idx+1));
            } else{
                Set<String> curDir=dirs.get(path);
                return new ArrayList<>(curDir);
            }
        }

        public void mkdir(String path){
            if(!dirs.containsKey(path)) {
                String[] dir = path.split("/");
                String key = "/";
                for (String d : dir) {
                    dirs.putIfAbsent(key, new TreeSet<>());
                    Set<String> curDir = dirs.get(key);
                    curDir.add(d);
                    key += d;
                }
            }
        }

        public void addContentToFile(String filePath, String content){
            int idx=filePath.lastIndexOf("/");
            String dir=filePath.substring(0,idx);
            String file=filePath.substring(idx+1);
            mkdir(dir);
            dirs.get(dir).add(file);
            files.put(filePath, content);
        }

        public String readContentFromFile(String filePath){
            return files.get(filePath);
        }
    }
}
