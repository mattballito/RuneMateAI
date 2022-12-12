package com.mattzabally.scripts.agility.gnome_village.leafs;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.local.Skill;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

/**
 * NOTES:
 * 
 */
public class ClimbOverObstacleNetSecond extends LeafTask {

    @Override
    public void execute() {
        GameObject ClimbableNetSecond = GameObjects.newQuery().ids(23135).results().nearest();
        Player player = Players.getLocal();
        if (ClimbableNetSecond != null){
            int agilityXPbefore = Skill.AGILITY.getExperience();
            if (ClimbableNetSecond.isVisible()){
                if (ClimbableNetSecond.interact("Climb-over")){
                    Execution.delayUntil(()->!ClimbableNetSecond.isValid() || Skill.AGILITY.getExperience() > agilityXPbefore, 200, 3000);
                    Execution.delayUntil(()-> player.getAnimationId() == -1, 200,5000);
                }
            }
            else{
                Camera.turnTo(ClimbableNetSecond);
            }
        }
        else{
            Environment.getBot().getLogger().info("The Net we looked for in ClimbOverObstacleNetSecond was null");
        }
    }
}
