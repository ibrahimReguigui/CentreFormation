package com.example.centre_formation.activity;

import com.example.centre_formation.entity.Prof;

public interface OnProfListener {
    void onProfUpdate(Prof prof);
    void onProfDelete(Prof prof);
    void onProfDeleted(int profId); // Add this method
}