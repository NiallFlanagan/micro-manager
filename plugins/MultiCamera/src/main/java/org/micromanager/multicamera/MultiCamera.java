package org.micromanager.multicamera;

import mmcorej.CMMCore;
import org.micromanager.MMPlugin;
import org.micromanager.Studio;


public class MultiCamera implements MMPlugin {
   public static final String menuName = "Multi-Andor Control";
   public static final String tooltipDescription =
      "Control settings for one or more Andor EM-CCD cameras via the " +
      "Multi Camera device"; 

   private CMMCore core_;
   private Studio gui_;
   private MultiCameraFrame myFrame_;

    @Override
   public void setApp(Studio app) {
      gui_ = app;                                        
      core_ = app.getCMMCore();
      if (myFrame_ == null) {
         try {
            myFrame_ = new MultiCameraFrame(gui_);
            gui_.compat().addMMListener(myFrame_);
         } catch (Exception e) {
            gui_.logs().showError(e);
            return;
         }
      }
      myFrame_.setVisible(true);
   }

   @Override
   public void dispose() {
   }

   @Override
   public void show() {
         String ig = "Andor Control";
   }

    @Override
   public String getInfo () {
      return "Multi Camera Plugin";
   }

    @Override
   public String getDescription() {
      return tooltipDescription;
   }
   
    @Override
   public String getVersion() {
      return "0.12";
   }
   
    @Override
   public String getCopyright() {
      return "University of California, 2010, 2011";
   }
}