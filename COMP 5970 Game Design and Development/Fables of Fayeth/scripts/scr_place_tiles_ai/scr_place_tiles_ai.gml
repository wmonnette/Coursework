mp_grid_clear_rectangle(global.map_grid, 0, 0, room_width, room_height);

with (par_Enemy) 
{
	if (self.id != global.selected.id) 
	{
		mp_grid_add_rectangle(global.map_grid, x, y, x, y);
		instance_create_depth(round(x/64)*64, round(y/64)*64, 0, obj_TileUnwalkable);
	}
}

with (par_Player) 
{
	mp_grid_add_rectangle(global.map_grid, x, y, x, y);
	instance_create_depth(round(x/64)*64, round(y/64)*64, 0, obj_TileAttack);	
}
//with (obj_Collision)
//{
//	mp_grid_add_rectangle(global.map_grid, x, y, x, y);
//	instance_create_depth(round(x/64)*64, round(y/64)*64, 0, obj_TileUnwalkable);	
//}

var i_x;
for(i = 0; i < 18; i++) 
{	
	i_x = 64 + 64 * i;
	if (mp_grid_path(global.map_grid, global.navigate, global.selected.current_node_x, global.selected.current_node_y, i_x, row, 1)) 
	{
		if (path_get_length(global.navigate) > global.selected.pixel_distance) 
			&& (path_get_length(global.navigate) < global.selected.pixel_distance * 1.5) 
			{
				mp_grid_add_rectangle(global.map_grid, i_x, row, i_x, row);
				instance_create_layer(i_x, row, "Instances", obj_TileUnwalkable);
			}
		if (path_get_length(global.navigate) <= global.selected.pixel_distance) 
		{		
			instance_create_layer(i_x, row, "Instances", obj_TileWalkable_ai);
		}
	} else 
	{
		mp_grid_add_rectangle(global.map_grid, i_x, row, i_x, row);
	}	
	if(i_x >= 576) 
	{
		i = 0;
		row += 64;
	}
	
	if (row > 600) 
	{
		row = 0;
		i = 20;	
	}
}