package com.wen.FourthFifty;

public class CompareVersionNumbers {
    // My way(padding versions start or end with "." first)
    public int compareVersion(String version1, String version2) {
        version1=paddingVersion(version1);
        version2=paddingVersion(version2);
        String[] subv1=version1.split("\\.");
        String[] subv2=version2.split("\\.");
        int l1=subv1.length, l2=subv2.length, l=Math.min(l1, l2);
        for(int i=0; i<l; i++) {
            int v1=Integer.parseInt(subv1[i].trim());
            int v2=Integer.parseInt(subv2[i].trim());
            if(v1<v2) {
                return -1;
            } else if(v1>v2) {
                return 1;
            } else {
                continue;
            }
        }
        if(l1>l) {
            for(int i=l; i<l1; i++) {
                if(Integer.parseInt(subv1[i].trim())==0) {
                    continue;
                }
                return 1;
            }
        }
        if(l2>l) {
            for(int i=l; i<l2; i++) {
                if(Integer.parseInt(subv2[i].trim())==0) {
                    continue;
                }
                return -1;
            }
        }
        return 0;
    }

    private String paddingVersion(String version) {
        if(version.trim().startsWith(".")) {
            version="0"+version;
        }
        if(version.trim().endsWith(".")) {
            version=version+"0";
        }
        return version;
    }
}
