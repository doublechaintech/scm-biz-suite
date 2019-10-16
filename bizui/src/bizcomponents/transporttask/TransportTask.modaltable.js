
import React, { PureComponent } from 'react'
import moment from 'moment'
import { Table, Alert, Badge } from 'antd'
import styles from './TransportTask.table.less'
import ImagePreview from '../../components/ImagePreview'
import TransportTaskBase from './TransportTask.base'
<<<<<<< HEAD

=======
import appLocaleName from '../../common/Locale.tool'
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

class TransportTaskModalTable extends PureComponent {
  render() {
    // const { data,count,current, owner } = this.props
    const { data } = this.props
	const {displayColumns} = TransportTaskBase
<<<<<<< HEAD
	
=======
	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
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
<<<<<<< HEAD
                一共 <a style={{ fontWeight: 600 }}>{data.length}</a> 项 
=======
                {appLocaleName(userContext,"Totally")} <a style={{ fontWeight: 600 }}>{data.length}</a> {appLocaleName(userContext,"Items")} 
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
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
          scroll={{ x: 1140 }}
        />
      </div>
    )
  }
}

export default TransportTaskModalTable

