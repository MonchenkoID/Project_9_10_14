package com.github.monchenkoid.project_9_10_14.garbage;

import java.io.Serializable;

/**
 * Created by Irina Monchenko on 23.10.2014.
 */
public class TIMGsonModel implements Serializable {

    private Long id;
    private String name;
    private String mbti;
    private String iore;
    private String nors;
    private String torf;
    private String porj;

    public TIMGsonModel(Long id, String name, String mbti, String iore,
                        String nors, String torf, String porj) {
        this.id = id;
        this.name = name;
        this.mbti = mbti;
        this.iore = iore;
        this.nors = nors;
        this.torf = torf;
        this.porj = porj;

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMbti() {
        return mbti;
    }

    public String getIore() {
        return iore;
    }

    public String getNors() {
        return nors;
    }

    public String getTorf() {
        return torf;
    }

    public String getPorj() {
        return porj;
    }
}
