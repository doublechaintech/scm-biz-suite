import { getExtMode, isEmpty, isNotEmpty } from '@/nice-router/nice-router-util';
import { View } from '@tarojs/components';
import classNames from 'classnames';
import _ from 'lodash';
import EleTable from '@/components/ele-table/ele-table';
import EleTableRow from '@/components/ele-table/ele-table-row';
import EleTableCell from '@/components/ele-table/ele-table-cell';
import { TitleValue } from '@/nice-router/nice-router-types';

import './card-info-table.scss';

const getMaxLabelLength = (list, idx = 0) => {
  const result = _.max(
    list.map((it) => {
      const titleLength = _.get(it, idx + '.title', '').length;
      return titleLength > 2 ? titleLength : 2;
    })
  );
  // @ts-ignore
  return result > 5 ? 5 : result;
};

type CardInfoTableProps = {
  data: (TitleValue | null)[];
  className?: string;
};

export default function CardInfoTable(props: CardInfoTableProps) {
  const { data = [], className } = props;
  const rowList = _.chunk(data, 2);
  const rootClass = classNames('card-info-table', className);
  const maxLabelLengthLeft = getMaxLabelLength(rowList, 0);
  const maxLabelLengthRight = getMaxLabelLength(rowList, 1);
  const leftItemLabelClass = getExtMode({
    [`width${maxLabelLengthLeft}`]: true,
  }).classNames('card-info-table-label');

  const rightItemLabelClass = getExtMode({
    [`width${maxLabelLengthRight}`]: true,
  }).classNames('card-info-table-label');

  return (
    <View className={rootClass}>
      <EleTable bordered={false}>
        {rowList.map((row: [TitleValue, TitleValue], idx) => {
          const leftItem = row[0] || {};
          const rightItem = row[1] || {};
          const showRight = isNotEmpty(rightItem);

          let colspan = 1;
          if (!showRight) {
            colspan = isEmpty(leftItem.title) ? 4 : 3;
          }

          return (
            <EleTableRow key={idx}>
              {isNotEmpty(leftItem.title) && (
                <EleTableCell title={leftItem.title} className={leftItemLabelClass} mode='left' />
              )}

              <EleTableCell title={leftItem.value} colspan={colspan} mode='left' />

              {showRight && (
                <>
                  <EleTableCell title={rightItem.title} className={rightItemLabelClass} mode='left' />
                  <EleTableCell title={rightItem.value} mode='left' />
                </>
              )}
            </EleTableRow>
          );
        })}
      </EleTable>
    </View>
  );
}
