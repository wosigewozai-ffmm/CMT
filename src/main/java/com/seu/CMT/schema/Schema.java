package com.seu.CMT.schema;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Schema {
    Map<String, Integer> map = new HashMap<String,Integer>();

    private String[][] relation = new String[9][9];

    public Schema() {
        map.put("方剂",1);
        map.put("功效",2);
        map.put("药材",3);
        map.put("症状",4);
        map.put("功用大类",5);
        map.put("功用小类",6);
        String path = "C:\\Users\\yuhongtao\\IdeaProjects\\CMT\\target\\classes\\static\\schema\\schemaLog.txt";
        File file = new File(path);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                String entityA = new String();
                String _relation = new String();
                String entityB = new String();
                int i=1;
                while (tempStr.charAt(i)!='，'){
                    entityA += tempStr.charAt(i);
                    i++;
                }
                i++;
                while (tempStr.charAt(i)!='，'){
                    _relation += tempStr.charAt(i);
                    i++;
                }
                i++;
                while (i<tempStr.length()-1){
                    entityB += tempStr.charAt(i);
                    i++;
                }
                relation[map.get(entityA)][map.get(entityB)]=_relation;
                sbf.append(tempStr);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public int relationMap(String entity){
        if (entity!=null)
            return map.get(entity);
        return 0;
    }

    public String[][] getRelation() {
        return relation;
    }

    public void setRelation(String[][] relation) {
        this.relation = relation;
    }
}
