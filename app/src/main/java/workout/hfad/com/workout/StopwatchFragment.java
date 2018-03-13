package workout.hfad.com.workout;


import android.os.Bundle;
import android.os.Handler;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class StopwatchFragment extends Fragment implements View.OnClickListener{

    private int seconds = 0;

    private boolean wasRunning;
    private boolean running;

    public StopwatchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
            running = savedInstanceState.getBoolean("running");
            if (wasRunning){
                running = true;
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stopwatch, container, false);
        runTimer(view);
        Button start_button = (Button) view.findViewById(R.id.start_button);
        start_button.setOnClickListener(this);
        Button stop_button = (Button) view.findViewById(R.id.stop_button);
        stop_button.setOnClickListener(this);
        Button reset_button = (Button) view.findViewById(R.id.reset_button);
        reset_button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (wasRunning) running = true;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds", seconds);
        outState.putBoolean("wasRunning", wasRunning);
        outState.putBoolean("running", running);
    }

    public void onClickStart(View view){
        running = true;
    }

    public void onClickStop(View view){
        running = false;
    }

    public void onClickReset(View view){
        running = false;
        seconds = 0;
    }

    public void runTimer(View view){
        final TextView timer = (TextView) view.findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                timer.setText(time);
                if (running){
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_button:
                onClickStart(view);
                break;
            case R.id.stop_button:
                onClickStop(view);
                break;
            case R.id.reset_button:
                onClickReset(view);
                break;
        }
    }
}
