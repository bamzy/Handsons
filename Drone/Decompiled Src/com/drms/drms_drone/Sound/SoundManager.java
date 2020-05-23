package com.drms.drms_drone.Sound;

import android.content.Context;
import android.media.SoundPool;
import android.util.Log;
import java.util.HashMap;

public class SoundManager {
  private Context mContext;
  
  private SoundPool mSoundPool;
  
  private HashMap<Integer, Integer> map;
  
  public SoundManager(Context paramContext) {
    this.mContext = paramContext;
    this.mSoundPool = new SoundPool(5, 3, 0);
    this.map = new HashMap<Integer, Integer>();
    addSound(0, 2131165185);
    addSound(1, 2131165185);
  }
  
  public void addSound(int paramInt1, int paramInt2) {
    paramInt2 = this.mSoundPool.load(this.mContext, paramInt2, 1);
    this.map.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void play(int paramInt) {
    Log.d("Sound", "play");
    try {
      Thread.sleep(1L);
    } catch (InterruptedException interruptedException) {}
    this.mSoundPool.play(((Integer)this.map.get(Integer.valueOf(paramInt))).intValue(), 1.0F, 1.0F, 1, 0, 1.0F);
  }
  
  public void stopSound(int paramInt) {
    this.mSoundPool.stop(((Integer)this.map.get(Integer.valueOf(paramInt))).intValue());
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Sound\SoundManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */