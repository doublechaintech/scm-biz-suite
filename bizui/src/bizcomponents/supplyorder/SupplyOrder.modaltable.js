
import React, { PureComponent } from 'react'
import moment from 'moment'
import { Table, Alert, Badge } from 'antd'
import styles from './SupplyOrder.table.less'
import ImagePreview from '../../components/ImagePreview'
import SupplyOrderBase from './SupplyOrder.base'
import appLocaleName from '../../common/Locale.tool'

class SupplyOrderModalTable extends PureComponent {
  render() {
    // const { data,count,current, owner } = this.props
    const { data } = this.props
	const {displayColumns} = SupplyOrderBase
	const userContext = null
	if(!data){
		return null
	}
	if(!data.length){
		return null
	}
	
    return (
      <div className={styles.standardTable}>
        <div className={styles.tableAlert}>
          <Alert
            message={(
              <p>
                {appLocaleName(userContext,"Totally")} <a style={{ fontWeight: 600 }}>{data.length}</a> {appLocaleName(userContext,"Items")} 
              </p>
            )}
            type="warning"
            showIcon
          />
        </div>
        <Table
          rowKey={record => record.id}
          dataSource={data}
          columns={displayColumns}
          size="small"
<<<<<<< HEAD
          scroll={{ x: 1770 }}
=======
          scroll={{ x: 1635 }}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
        />
      </div>
    )
  }
}

export default SupplyOrderModalTable

