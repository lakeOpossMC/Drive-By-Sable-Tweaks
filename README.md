Drive-By-Sable Tweaks is an addon mod for Drive-By-Wire that changes some block behaviors.

This is done be overriding the original block and item ids to preffer new directional versions. 
After many attempts using other methods, I reached the conclusion that this would be the best way to acheive blockstate based rotation (similar to the rotation states of a vanilla minecraft Lever).

NOTE: There is likely to be bugs that I have not discovered in my testing. I'm a beginner dev.

KNOWN ISSUES:
- Latest update/beta release method for overriding drivebywire block registers still allows for the original blocks to be obtained through crafting and /give commands.
- New directional blocks are not craftable as of latest beta release.
- Previous beta releases caused mouseClicked event handler crash when exiting world and NullPointerException when joining server.

Fixes for these issues are coming in the next beta release. Likely will be switching back to the old method for overriding the block ids, BUT in a way that ensures crashes will not be an issue upon exiting the world. (This was due to an oversight that caused nepforge to be unable to match the new block facing properties with the old ones upon data cleanup when stopping the client.)