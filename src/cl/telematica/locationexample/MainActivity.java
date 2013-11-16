package cl.telematica.locationexample;

import cl.telematica.locationexample.interfaces.LocationListenerHandler;
import cl.telematica.locationexample.location.ActiveLocationManagerActivity;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends ActiveLocationManagerActivity {
	
	private TextView latitudText;
	private TextView longitudText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		latitudText = (TextView) findViewById(R.id.textView4);
		longitudText = (TextView) findViewById(R.id.textView5);
		
		listener = new LocationListenerHandler() {
			@Override
			public void OnLocationReceived(Location loc) {
				latitudText.setText("" + loc.getLatitude());
				longitudText.setText("" + loc.getLongitude());
			}
        };
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
