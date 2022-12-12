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
public class ClimbDownTreeBranch extends LeafTask {

    @Override
    public void execute() {
        GameObject TreeBranchDown = GameObjects.newQuery().ids(23560).results().nearest();
        if (TreeBranchDown != null){
            int agilityXPbefore = Skill.AGILITY.getExperience();
            if (TreeBranchDown.isVisible()){
                if (TreeBranchDown.interact("Climb-down")){
                    Execution.delayUntil(()->!TreeBranchDown.isValid() || Skill.AGILITY.getExperience() > agilityXPbefore, 200, 3000);
                }
            }
            else{
                Camera.turnTo(TreeBranchDown);
            }
        }
        else{
            Environment.getBot().getLogger().info("The Branch we looked for in ClimbDownTreeBranch was null");
        }
    }
}
