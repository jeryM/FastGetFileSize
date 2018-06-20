package cordova.plugin.fastGetFileSize;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import android.os.Environment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

/**
 * This class echoes a string called from JavaScript.
 */
public class FastGetFileSize extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }
		if(action.equals("getFileSize")){
			String externalRootDirectory = args.getString(0);
			String filepath = args.getString(1);
			this.getFileSize(externalRootDirectory,filepath,callbackContext);
			return true;
		}
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
	
	private void getFileSize(String externalRootDirectory,String filepath,CallbackContext callbackContext){
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
			try {
				File file= new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+filepath);
				//callbackContext.success("file.exists():"+file.exists()+",file.isFile():"+file.isFile());
				if (file.exists() && file.isFile()){ 
                     JSONObject json = new JSONObject();
                     json.put("fileSize",file.length());
                     json.put("fileAbsolutePage",file.getAbsolutePath());					 
                     callbackContext.success(""+file.length());
                }else{  
                     callbackContext.error("file doesn't exist or is not a file");  
                }  
			} catch (Exception e) {
				callbackContext.error(e.getMessage());
			}
		//}
		//callbackContext.error("未发现外部存储");
		
	}
}
