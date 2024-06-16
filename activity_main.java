package com.example.asynctask2;
import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.ViewFlipper;
public class MainActivity extends AppCompatActivity {
  private Button btn1,btn2;
  Animation fade_in,fade_out;
  ViewFlipper viewFlipper;
  TextView txt;
  VideoView video;
  
  @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    viewFlipper=(ViewFlipper)this.findViewById(R.id.bckgrndViewFlipper1);
    VideoView videoView = findViewById(R.id.videoView);
    videoView.setVideoPath("android.resource://"+getPackageName()+"/"+
    R.raw.v2);
    MediaController mediaController = new MediaController(this);
    mediaController.setAnchorView(videoView);
    videoView.setMediaController(mediaController);
    fade_in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
    fade_out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
    viewFlipper.setInAnimation(fade_in);
    viewFlipper.setOutAnimation(fade_out);
    //sets auto flipping
    viewFlipper.setAutoStart(true);
    viewFlipper.setFlipInterval(5000);
    viewFlipper.startFlipping();
    txt=findViewById(R.id.txtView);
    AsyncClass asyncClass=new AsyncClass();
    btn1=findViewById(R.id.btnStart);
    btn2=findViewById(R.id.btnStop);
    btn1.setOnClickListener(new View.OnClickListener() {
    @Override
        public void onClick(View v) {
        asyncClass.doInBackground();
        asyncClass.onProgressUpdate();
        }
    });
      btn2.setOnClickListener(new View.OnClickListener() {
        @Override
          public void onClick(View v) {
          txt.setSelected(false);
          asyncClass.onPostExecute("LET US MAKE THE CORAL FLORAL AGAIN");
          }
      });
    }
    private class AsyncClass extends AsyncTask<String,String,String>{
      @Override
        protected void onPreExecute() {
        super.onPreExecute();
    }
      @Override
        protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        Toast.makeText(getApplicationContext(),"BE MORAL WITH CORAL",Toast.LENGTH_SHORT).show();
      }
      @Override
        protected String doInBackground(String... strings) {
        txt.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        txt.setSelected(true);
        return null;
      }
      @Override
        protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
      }
    }
  }
