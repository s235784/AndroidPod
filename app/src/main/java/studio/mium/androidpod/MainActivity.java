package studio.mium.androidpod;

import android.os.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.text.method.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements OnClickListener
{
	TextView Console;
	ScrollView Console_scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		Console = (TextView)findViewById(R.id.TextView_Console);
		Console.setMovementMethod(ScrollingMovementMethod.getInstance());

		Console_scrollView = (ScrollView)findViewById(R.id.Console_scrollView);

		Button fornt = (Button)findViewById(R.id.button_front);
		Button back = (Button)findViewById(R.id.button_back);
		Button left = (Button)findViewById(R.id.button_left);
		Button right = (Button)findViewById(R.id.button_right);
		Button clean = (Button)findViewById(R.id.Console_clean);
		fornt.setOnClickListener(this);
		back.setOnClickListener(this);
		left.setOnClickListener(this);
		right.setOnClickListener(this);
		clean.setOnClickListener(this);
    }

	@Override
	public void onClick(View p1)
	{
		String text = Console.getText().toString();
		switch (p1.getId())
		{
			case R.id.button_front:
				Console.setText(text + "\n控制台:前进");
				break;
			case R.id.button_back:
				Console.setText(text + "\n控制台:后退");
				break;
			case R.id.button_left:
				Console.setText(text + "\n控制台:左转");
				break;
			case R.id.button_right:
				Console.setText(text + "\n控制台:右转");
				break;
			case R.id.Console_clean:
				Console.setText("=====分割线=====");
				break;
		}
		Console_scrollView.post(new Runnable()
		{
				@Override
				public void run()
				{
					Console_scrollView.fullScroll(ScrollView.FOCUS_DOWN);
				}
			});
	}
}
