package com.example.hanoiguide_lichtrinh;

import it.neokree.materialnavigationdrawer.elements.MaterialAccount;


import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.ProfilePictureView;
import com.facebook.share.Sharer;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HaNoiFragment extends Fragment {

	private CallbackManager callbackManager;
	private ProfileTracker profileTracker;
	private MaterialAccount account;
	private Button postStatusUpdateButton;
	private Button postPhotoButton;
	private ProfilePictureView profilePictureView;
	private TextView greeting;
	View v;
	private FacebookCallback<Sharer.Result> shareCallback = new FacebookCallback<Sharer.Result>() {
		@Override
		public void onCancel() {
			Log.d("HelloFacebook", "Canceled");
		}

		@Override
		public void onError(FacebookException error) {
			Log.d("HelloFacebook", String.format("Error: %s", error.toString()));
			String title = getString(R.string.error_occured);
			String alertMessage = error.getMessage();
			showResult(title, alertMessage);
		}

		@Override
		public void onSuccess(Sharer.Result result) {
			Log.d("HelloFacebook", "Success!");
			if (result.getPostId() != null) {
				String title = getString(R.string.store_picture_title);
				String id = result.getPostId();
				String alertMessage = getString(R.string.store_picture_title,
						id);
				showResult(title, alertMessage);
			}
		}

		private void showResult(String title, String alertMessage) {
			new AlertDialog.Builder(getActivity()).setTitle(title)
					.setMessage(alertMessage)
					.setPositiveButton(R.string.app_name, null).show();
		}
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		FacebookSdk.sdkInitialize(this.getActivity());
		callbackManager = CallbackManager.Factory.create();

		LoginManager.getInstance().registerCallback(callbackManager,
				new FacebookCallback<LoginResult>() {
					@Override
					public void onSuccess(LoginResult loginResult) {
						showAlert();
						updateUI();
					}

					@Override
					public void onCancel() {
						showAlert();
						updateUI();
					}

					@Override
					public void onError(FacebookException exception) {
						showAlert();
						updateUI();

					}

					private void showAlert() {
						new AlertDialog.Builder(getActivity())
								.setTitle("Cancel").setMessage("Permission")
								.setPositiveButton("OK", null).show();
					}
				});
		v = inflater.inflate(R.layout.main, container, false);

		profileTracker = new ProfileTracker() {
			@Override
			protected void onCurrentProfileChanged(Profile oldProfile,
					Profile currentProfile) {
			}
		};
		profilePictureView = (ProfilePictureView) v.findViewById(R.id.profilePicture);        

        postStatusUpdateButton = (Button) v.findViewById(R.id.postStatusUpdateButton);
      
        postPhotoButton = (Button) v.findViewById(R.id.postPhotoButton);

		Profile profile = Profile.getCurrentProfile();
		return v;
	}

	private void updateUI() {
		boolean enableButtons = AccessToken.getCurrentAccessToken() != null;

		postStatusUpdateButton.setEnabled(enableButtons);
		postPhotoButton.setEnabled(enableButtons);

		Profile profile = Profile.getCurrentProfile();
		if (enableButtons && profile != null) {
			profilePictureView.setProfileId(profile.getId());
			greeting.setText("Hello");
		} else {
			profilePictureView.setProfileId(null);
			greeting.setText(null);
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		callbackManager.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		AppEventsLogger.deactivateApp(getActivity());
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		profileTracker.stopTracking();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

}
