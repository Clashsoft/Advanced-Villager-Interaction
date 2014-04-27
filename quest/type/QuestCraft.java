package clashsoft.mods.villagerquests.quest.type;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;

public class QuestCraft extends QuestType
{
	public Item	item;
	
	public QuestCraft(String name, float reward, Block block)
	{
		this(name, reward, Item.getItemFromBlock(block));
	}
	
	public QuestCraft(String name, float reward, Item item)
	{
		super(name, reward);
		this.item = item;
	}
	
	@Override
	public boolean hasAmount()
	{
		return true;
	}
	
	@Override
	public int getAmount(Random random)
	{
		int i = (int) (this.reward * 2.5F);
		return random.nextInt(16) + i;
	}
	
	@Override
	public boolean isCompleted(EntityPlayer player, int amount)
	{
		return QuestType.getItemCount(player, this.item, null) >= amount;
	}
}
