package monopoly.logic;

import monopoly.RightPanelGUI;

public class Property extends Space
{
	public int price;
	public Player owner;
	public PropertyType type;
	
	public Property(PropertyType propType, int spaceNumber, String name)
	{
		super(SpaceType.Property, spaceNumber, name);
		this.type = propType;
	}

	@Override
	public void effect(Player player)
	{
		if(owner != null && owner != player)
			payRent(player);
	}
	
	public void buy(Player ownerPlayer)
	{
		if (owner == null && ownerPlayer.playerCreditCard.money >= price)
		{
			this.owner = ownerPlayer;
			owner.playerCreditCard.debit(price);
			ownerPlayer.properties.add(this);
			RightPanelGUI.getSharedInstance().showMessage("You bought this property for " + price + " dollars!");
			return;
		}
		
		RightPanelGUI.getSharedInstance().showMessage("You cannot buy this property.");
	}
	
	public void payRent(Player player)
	{
		
	}
	
	public void recoverFromMortgage()
	{
		
	}
	
	public void mortgage()
	{
		
	}

}
