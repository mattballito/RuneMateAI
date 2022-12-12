package com.mattzabally.scripts.agility.gnome_village.leafs;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.local.Skill;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

/**
 * NOTES:
 * 
 */
public class ClimbOverObstacleNetFirst extends LeafTask {

    @Override
    public void execute() {
        GameObject ClimbableNet = GameObjects.newQuery().ids(23134).results().nearest();
        if (ClimbableNet != null){
            int agilityXPbefore = Skill.AGILITY.getExperience();
            if (ClimbableNet.isVisible()){
                if (ClimbableNet.interact("Climb-over")){
                    Execution.delayUntil(()->!ClimbableNet.isValid() || Skill.AGILITY.getExperience() > agilityXPbefore, 200, 3000);
                }
            }
            else{
                Camera.turnTo(ClimbableNet);
            }
        }
        else{
            Environment.getBot().getLogger().info("The Net we looked for in ClimbOverObstacleNetFirst was null");
        }
    }
}
