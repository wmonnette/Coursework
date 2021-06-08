/// @description Parallax Backgrounds

//Lerp layer coordinates to camera view

layer_x(nearBackgroundID, lerp(0, camera_get_view_x(view_camera[0]), 0.9)); //.9
layer_x(midBackgroundID, lerp(0, camera_get_view_x(view_camera[0]), 0.75)); //.75
layer_x(farBackgroundID, lerp(0, camera_get_view_x(view_camera[0]), 0.5)); //.5

