package com.seu.CMT.schema;

import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.*;

public class Schema {
    Map<String, Integer> map = new HashMap<String,Integer>();
    List<String> relationList = new ArrayList<>();
    List<String> entityList = new ArrayList<>();
    Map<String,Integer> relationMap = new HashMap<>();

    public List<String> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<String> entityList) {
        this.entityList = entityList;
    }

    public List<String> getRelationList() {
        return relationList;
    }

    public void setRelationList(List<String> relationList) {
        this.relationList = relationList;
    }

    private String[][] relation = new String[9][9];

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public Schema() throws IOException {
        ClassPathResource resource = new ClassPathResource("");
        String projectPath = resource.getFile().getAbsolutePath()+"\\static\\schema";
        String path = projectPath+"\\schemaLog.txt";
        File file = new File(path);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            int sum = 0;
            int sumRelation = 0;
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
                if (!map.containsKey(entityA)){
                    sum++;
                    map.put(entityA,sum);
                    entityList.add(entityA);
                }
                if (!relationMap.containsKey(_relation)){
                    sumRelation++;
                    relationMap.put(_relation,sumRelation);
                    relationList.add(_relation);
                }
                if (!map.containsKey(entityB)){
                    sum++;
                    map.put(entityB,sum);
                    entityList.add(entityB);
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
