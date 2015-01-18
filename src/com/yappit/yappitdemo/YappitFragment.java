/**
 * 
 */
package com.yappit.yappitdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


/**
 * @author rsudheen
 *
 */
public class YappitFragment extends Fragment {

	private View rootView;
	private Button yesImageButton;
	private Button noImageButton;
	private Button notsureButton;
	private ResultFragment mResultFragment;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_yappit, container,false);
		 yesImageButton = (Button)rootView.findViewById(R.id.yesButton);
	        noImageButton = (Button)rootView.findViewById(R.id.noButton);
	        notsureButton = (Button)rootView.findViewById(R.id.notsure);
	        mResultFragment= new ResultFragment();
	        
	        yesImageButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Toast.makeText(getActivity(), "You voted YES", Toast.LENGTH_LONG).show();
					ShowResults();
				    
				}
				
			});
	        
	        noImageButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Toast.makeText(getActivity(), "You voted NO", Toast.LENGTH_LONG).show();
					ShowResults();
					
				}
			});
	        
	        notsureButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Toast.makeText(getActivity(), "Well!! You are not sure", Toast.LENGTH_LONG).show();
					ShowResults();
				}
			});

		return rootView;
	}
	
	private void ShowResults() {
		 getActivity().getSupportFragmentManager().beginTransaction()
	     .replace(R.id.container, mResultFragment,"Result")
	     .addToBackStack(null)
	     .commit();
		
		
	}
	
	

}
