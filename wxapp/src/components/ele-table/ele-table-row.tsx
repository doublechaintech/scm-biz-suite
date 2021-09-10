import { View } from '@tarojs/components';
import React from 'react';
import EleTableCell, { EleTableCellProps } from '@/components/ele-table/ele-table-cell';
import classNames from 'classnames';
import './ele-table.scss';

export type EleTableRowProps = {
  items?: EleTableCellProps[];
  header?: any;
  className?: string;
  children?: React.ReactNode;
};

const EleTableRow: React.FC<EleTableRowProps> = (props) => {
  const { items = [], header, className } = props;
  const rootClass = classNames('ele-table-row', className, {
    'ele-table-row--header': header,
  });
  return (
    <View className={rootClass}>
      {items.map((it, idx) => (
        <EleTableCell key={`ele-table-cell-${idx}`} {...it} />
      ))}
      {props.children}
    </View>
  );
};

export default EleTableRow;
