package com.utils.gui_utils.objects.tables;

import java.util.List;

import com.utils.annotations.ApiMethod;
import com.utils.data_types.table.TableColumnData;
import com.utils.gui_utils.objects.search_and_filter.FilterType;
import com.utils.log.Logger;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.control.TableColumnBase;

public final class TableColumnUtils {

	private TableColumnUtils() {
	}

	@ApiMethod
	public static void setTableColumnData(
			final TableColumnBase<?, ?> tableColumnBase,
			final ReadOnlyDoubleProperty widthProperty,
			final double widthWeightSum,
			final TableColumnData tableColumnData) {

		final String columnName = tableColumnData.getName();
		tableColumnBase.setText(columnName);

		final double widthRatio = tableColumnData.computeWidthRatio(widthWeightSum);
		final DoubleBinding widthBinding = widthProperty.subtract(15).multiply(widthRatio);
		tableColumnBase.prefWidthProperty().bind(widthBinding);

		final double minWidth = tableColumnData.getMinWidth();
		if (!Double.isNaN(minWidth)) {
			tableColumnBase.setMinWidth(minWidth);
		}

		final double maxWidth = tableColumnData.getMaxWidth();
		if (!Double.isNaN(maxWidth)) {
			tableColumnBase.setMaxWidth(maxWidth);
		}
	}

	public static void printFilterAppliedMessage(
			final FilterType filterType,
			final int filterColumnIndex,
			final List<ColumnHeader> columnHeaderList) {

		final StringBuilder sbFilterAppliedMessage = new StringBuilder(128);
		sbFilterAppliedMessage.append(filterType).append(" filter applied");
		if (filterColumnIndex >= 0) {

			final ColumnHeader columnHeader = columnHeaderList.get(filterColumnIndex);
			final String filterColumnText = columnHeader.getColumnName();
			sbFilterAppliedMessage.append(" to column \"").append(filterColumnText).append('"');
		}
		final String filterAppliedMessage = sbFilterAppliedMessage.toString();

		Logger.printNewLine();
		Logger.printStatus(filterAppliedMessage);
	}
}