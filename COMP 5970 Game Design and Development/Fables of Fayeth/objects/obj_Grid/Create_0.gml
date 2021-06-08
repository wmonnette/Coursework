/// @description Creates the grid
// You can write your code in this editor
global.map_grid = mp_grid_create(0, 0, room_width/64, room_height/64, 64, 64);
global.navigate = path_add();