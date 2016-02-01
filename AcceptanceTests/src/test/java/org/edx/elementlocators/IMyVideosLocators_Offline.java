/**
 * 
 */
package org.edx.elementlocators;

/**
 * @author divakarpatil
 * 
 */
public interface IMyVideosLocators_Offline {

	public String getOfflineBarId();

	public String getOfflineLabelName();

	public String getTxtMyVideosId();

	public String getHeaderId();

	public String getPlayPauseId();

	public String getSeekBarId();

	public String getVideoPlayerId();

	public String getRewindId();

	public String getSettingsPopUpId();

	public String getFullScreenId();

	public String getLMSId();

	public String getLstVideoId();

	public String getLstCourseId();

	public String getTxtAllVideosName();

	public String getTxtRecentVideosName();

	public String getOkPopupId();

	public String getBtnDeleteId();

	public String getCbVideoSelectId();

	public String getBtnEditId();

	public void gotoMyVideosView();

	String getVideoPlayerSettings();

	String getCourseListId();

	String getHeaderNameId();
	
	boolean isAndroid();
	
	String getTxtMyVideosName();
	
	public String getBtnDeletePopupId();

	// Android Locators
	String btnHeaderId = "android:id/up";
	String btnHeaderNameId = "android:id/action_bar_title";
	String btnCourseId = "org.proversity.edx.mobile:id/course_row_layout";
	String txtMyVideosName = "My Videos";
	String txtMyVideosId = "org.proversity.edx.mobile:id/drawer_option_my_videos";
	String txtAllVideosName = "All Videos";

	String btnOkPopupId = "org.proversity.edx.mobile:id/positiveButton";
	String btnCancelPopupId = "org.proversity.edx.mobile:id/negativeButton";
	String btnLMS = "org.proversity.edx.mobile:id/lms_btn";
	String btnPlayPause = "org.proversity.edx.mobile:id/pause";
	String btnRewind = "org.proversity.edx.mobile:id/rew";
	String btnSettings = "org.proversity.edx.mobile:id/settings";
	String btnFullScreenId = "org.proversity.edx.mobile:id/fullscreen";
	String vpVideoPlayerId = "org.proversity.edx.mobile:id/preview";

	String btnViewId = "org.proversity.edx.mobile:id/button_view";

	String txtRecentVideosName = "Recent Videos";
	String lstVideoId = "org.proversity.edx.mobile:id/video_row_layout";
	String btnEditId = "org.proversity.edx.mobile:id/edit_btn";
	String btnDeleteId = "org.proversity.edx.mobile:id/delete_btn";
	String btnCancelId = "org.proversity.edx.mobile:id/cancel_btn";
	String cbAllSelectId = "org.proversity.edx.mobile:id/select_checkbox";
	String cbVideoSelectId = "org.proversity.edx.mobile:id/video_select_checkbox";
	String lstAllVideos_Courses = "org.proversity.edx.mobile:id/my_video_course_list";
	String lstRecentVideos = "org.proversity.edx.mobile:id/list_video";
	
	String offlineBarId = "org.proversity.edx.mobile:id/offline_bar";
	

	// iOS Id's
	String btnHeaderIdiOS = "btnNavigation";
	String btnHeaderNameIdiOS = "myVideosHeader";
	String btnCourseIdiOS = "";
	String txtMyVideosNameiOS = "My Videos";
	String txtMyVideosIdiOS = "txtMyVideosLNP";
	String txtAllVideosNameiOS = "ALL VIDEOS";

	String btnOkPopupIdiOS = "Delete";
	String btnCancelPopupIdiOS = "Cancel";
	String btnLMSiOS = "btnLMS";
	String btnPlayPauseiOS = "btnPlayPause";
	String btnRewindiOS = "btnRewind";
	String btnSettingsiOS = "btnSettings";
	String btnFullScreenIdiOS = "btnFullScreen";
	String vpVideoPlayerIdiOS = "Video";

	String txtRecentVideosNameiOS = "RECENT VIDEOS";
	String lstVideoIdiOS = "lbVideoName";
	String btnEditIdiOS = "btnEdit";
	String btnDeleteIdiOS = "btnDelete";
	String btnCancelIdiOS = "btnCancel";
	String cbAllSelectIdiOS = "";
	String cbVideoSelectIdiOS = "btnCheckBoxDelete";
	String lstAllVideos_CoursesiOS = "lbCourseTitle";
	String lstRecentVideosiOS = "";
	String offlineBarIdiOS = "offline";

	String txtOfflineName = "OFFLINE MODE";
	String btnDeletePopupIdiOS = "Delete";
	
	
}
