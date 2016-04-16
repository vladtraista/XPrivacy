package biz.bokhorst.xprivacy;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ActivityContexts extends Activity {

	private final String TAG = "ActivityContexts";
	private  Button addContextButton;
	private  EditText contextNameText;
	private  ListView contextsView;
	private  ArrayAdapter<String> contextsAdapter;
	private List<String> contexts = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_contexts);
		
		contextsView = (ListView) findViewById(R.id.contextsListView);
		contextsAdapter = new ArrayAdapter<String>(this, R.layout.context_listview_row, R.id.rowContextName, contexts);
		contextsView.setAdapter(contextsAdapter);
		
		contextNameText = (EditText) findViewById(R.id.contextNameText);
		addContextButton = (Button) findViewById(R.id.addContextButton);
		addContextButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (contextNameText.getText().toString().equals("")){
					// Notify user that there is no input
					Toast.makeText(v.getContext(), "No user input for context name", Toast.LENGTH_SHORT).show();
				} else {
					contexts.add(contextNameText.getText().toString());
					contextsAdapter.notifyDataSetChanged();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_contexts, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
