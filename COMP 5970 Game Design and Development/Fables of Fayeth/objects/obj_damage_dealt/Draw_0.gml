/// @description Displays damage and destroys itself
// You can write your code in this editor
alpha+= 0.01;
y += 1;

draw_text_color(x-8, y, global.damage_dealt,0,0,0,0,1-alpha);
if (alpha == 1) {
	instance_destroy();	
}