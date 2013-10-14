package com.main;

import java.awt.Image;



public class GrillaBlock {
	 int width;
	  int height;
	  int step = 0;
	  int time = 0;
	  int gametime = 0;
	  int starttime = 0;
	  int speedLevel = 0;
	  
	  Block[][] blocks = new Block[12][8];
	  int angle = 90;
	  
	  int splash_flag = 0;

	  int collisionBid = -1;
	  int dist = 0;
	  boolean coll_bubble_flag = false;
	  boolean coll_top_flag = false;

	  int c_X = 0;
	  int c_Y = 0;
	  
	  int pointX = 0;
	  int pointY = 0;
	  boolean gbflag = false;
	  int dx = 0;
	  int dy = 0;
	  int sx = 0;
	  int sy = 0;
	  boolean up;
	  boolean down;
	  boolean left;
	  boolean right;
	  int vtime = 0;
	  Image[] im_common;

	  boolean bloading = false;
	  int bX = 0; int bY = 0;
	  
	  int ltime = 0;
	  int delta;
	  int lpage = 0;
	  int btnX;
	  int btnY;
	  int barY;
	  int[][] pos1 = new int[4][2];
	  int[][] pos2 = new int[4][2];
	  int[][] pos = new int[4][2];
	  
	  public GrillaBlock()
	  {  
	    this.bX = 0;
	    this.bY = 0;
	    for (int i = 0; i < 12; i++)
	      for (int j = 0; j < 8; j++)
	        this.blocks[i][j] = new Block();
	    //try
	    //{
	      //this.im_common = new Image[12];
	      //loadDatOnece("common", this.im_common, 0, 0, 12);
	     
	   // }
	    //catch (Exception e) {
	      //System.out.println("" + e.toString());
	    //}
	  }

}
