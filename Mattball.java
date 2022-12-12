package com.mattzabally.scripts.agility.gnome_village;




import com.runemate.game.api.script.framework.tree.TreeBot;
import com.runemate.game.api.script.framework.tree.TreeTask;


/**
 * NOTES:
 * This is the root node.
 * 
Add children of this branch using the settings to the right.
 */
public class Mattball extends TreeBot {

    /** notes to myself
     *
     */

    @Override
    public TreeTask createRootTask() { return new inStartingZone(); }
}
