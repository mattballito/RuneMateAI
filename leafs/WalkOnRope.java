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
public class WalkOnRope extends LeafTask {

    @Override
    public void execute() {
        GameObject WalkableRope = GameObjects.newQuery().ids(23557).results().nearest();
        if (WalkableRope != null){
            int agilityXPbefore = Skill.AGILITY.getExperience();
            if (WalkableRope.isVisible()){
                if (WalkableRope.interact("Walk-on")){
                    Execution.delayUntil(()->!WalkableRope.isValid() || Skill.AGILITY.getExperience() > agilityXPbefore, 200, 3000);
                }
            }
            else{
                Camera.turnTo(WalkableRope);
            }
        }
        else{
            Environment.getBot().getLogger().info("The Rope we looked for in WalkOnRope was null");
        }
    }
}
