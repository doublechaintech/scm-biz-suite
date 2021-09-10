import DetailDateTime from './detail-datetime';
import DetailFile from './detail-file';
import DetailImage from './detail-image';
import DetailImageList from './detail-image-list';
import DetailMobile from './detail-mobile';
import DetailObject from './detail-object';
import DetailStatus from './detail-status';
import DetailText from './detail-text';
import DetailUser from './detail-user';

function PropItem({ type, item, schema }) {
  const displayMode = JSON.parse(schema.displayMode);
  const newSchema = { ...schema, displayMode };

  if (type === 'money') return <DetailText inline={false} value={item} className='detail-money' />;
  if (type === 'longtext') return <DetailText inline={false} value={item} />;
  if (type === 'mobile') return <DetailMobile value={item} />;

  if (type === 'auto') return <DetailObject {...item} schema={newSchema} />;
  if (type === 'user') return <DetailUser {...item} schema={newSchema} />;

  if (type === 'status') return <DetailStatus {...item} />;
  if (type === 'date') return <DetailDateTime value={item} />;
  if (type === 'datetime') return <DetailDateTime value={item} format='yyyy-MM-dd HH:mm' />;

  if (type === 'document') return <DetailFile documentUrl={item} />;
  if (type === 'image') return <DetailImage imageUrl={item} />;
  if (type === 'image-list') return <DetailImageList items={item} />;
  if (type === 'section') return <DetailText value={item} className='center' />;
  return <DetailText value={item} />;
}

PropItem.defaultProps = {
  item: {},
  schema: {
    displayMode: '{}',
  },
};

export default PropItem;
