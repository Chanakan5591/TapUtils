package live.chanakancloud.taputils.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemUtils {
    /** check if the itemstack is a potion
     *
     * @param itemStack itemstack to check
     * @return boolean
     */
    public static boolean isPotion(ItemStack itemStack) {
        return itemStack.getType() == Material.POTION || itemStack.getType() == Material.SPLASH_POTION || itemStack.getType() == Material.LINGERING_POTION;
    }

    /** function to set lore for itemstack
     *
     * @param itemStack an item stack to set lore
     * @param lore a List of string that contain lore
     * @return ItemStack
     */
    public static ItemStack setLore(ItemStack itemStack, List<String> lore) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        if(itemMeta == null) return null;
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    /** function to set display name for itemstack
     *
     * @param itemStack an item stack to set lore
     * @param name a string contained name to be set
     * @return ItemStack
     */
    public static ItemStack setName(ItemStack itemStack, String name) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        if(itemMeta == null) return null;
        itemMeta.setDisplayName(name);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    /** to create new item stack
     *
     * @param material The material for the itemstack
     * @param amount the amount of items to be create
     * @param name the display name of the item stack
     * @param lore the lore of the item stack
     * @return ItemStack
     */
    public static ItemStack createItemStack(Material material, int amount, String name, String... lore) {
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta =  itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName(colorize(name));
        List<String> loreList = new ArrayList<>();
        for (String loree : lore) {
            loreList.add(colorize(loree));
        }
        itemMeta.setLore(loreList);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    private static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}
