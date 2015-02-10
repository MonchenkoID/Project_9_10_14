package com.github.monchenkoid.project_9_10_14.nd.dummy;


import com.github.monchenkoid.project_9_10_14.R;
import com.github.monchenkoid.project_9_10_14.nd.TimListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent
{

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<TimListAdapter.Counter> ITEMS = new ArrayList<TimListAdapter.Counter>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, TimListAdapter.Counter> ITEM_MAP = new HashMap<String, TimListAdapter.Counter>();

	static
	{
		// Add 3 sample items.
		addItem(new TimListAdapter.Counter("1", "Item 1", R.drawable.saturn));
		addItem(new TimListAdapter.Counter("2", "Item 2", R.drawable.venus));
		addItem(new TimListAdapter.Counter("3", "Item 3", R.drawable.uranus));
	}

	private static void addItem(TimListAdapter.Counter item)
	{
		ITEMS.add(item);
		ITEM_MAP.put(item.getName(), item);
	}

}

