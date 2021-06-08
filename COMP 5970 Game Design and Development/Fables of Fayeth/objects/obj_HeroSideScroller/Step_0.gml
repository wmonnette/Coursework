/// @description Insert description here
// You can write your code in this editor
event_inherited();

if (phy_position_xprevious > phy_position_x) 
{
	if (dashing == true)
	{
		sprite_index = spr_HeroDash;
		image_xscale = -1;
	}else 
	{
		sprite_index = spr_HeroRun;
		image_xscale = -1;
	}
	
} else if (phy_position_xprevious < phy_position_x)
{
	if (dashing == true) 
	{
		sprite_index = spr_HeroRun;
		image_xscale = 1;
	} else
	{
		sprite_index = spr_HeroRun;
		image_xscale = 1;
	}

} else 
{
	sprite_index = spr_HeroIdle;
}