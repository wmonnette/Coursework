///@func move(speed, direction)
/// @arg speed
/// @arg direction

var spd = argument0;
var dir = argument1;
 
var xtarg = x+lengthdir_x(spd,dir);
var ytarg = y+lengthdir_y(spd,dir);
 
if place_free(xtarg,ytarg) {
    phy_position_x = xtarg;
    phy_position_y = ytarg;
}
else {
    var sweep_interval = 10;
    
    for ( var angle = sweep_interval; angle <= 80; angle += sweep_interval) {
        for ( var multiplier = -1; multiplier <= 1; multiplier += 2) {      
            var angle_to_check = dir+angle*multiplier;
            xtarg = phy_position_x+lengthdir_x(spd, angle_to_check);
            ytarg = phy_position_y+lengthdir_y(spd, angle_to_check);     
            if place_free(xtarg,ytarg) {
                phy_position_x = xtarg;
                phy_position_y = ytarg;  
                exit;       
            }   
        }
    }
}