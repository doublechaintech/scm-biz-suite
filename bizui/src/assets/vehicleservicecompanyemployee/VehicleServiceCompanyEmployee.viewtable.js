import React, { PureComponent } from 'react'
import moment from 'moment'
import { Form, Button, Table, Alert, Badge } from 'antd'
import styles from './VehicleServiceCompanyEmployee.table.less'
import ImagePreview from '../../components/ImagePreview'

const columns = [
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20' },
  {
    title: '员工的名字',
    debugtype: 'string',
    dataIndex: 'employeeName',
    width: '7',
  },
  {
    title: '证件照片',
    dataIndex: 'profileImage',
    render: (text, record) => <ImagePreview imageLocation={record.证件照片} />,
  },
  {
    title: '性别',
    debugtype: 'string_gender',
    dataIndex: 'gender',
    width: '5',
  },
  {
    title: '工作状态',
    debugtype: 'string',
    dataIndex: 'availableState',
    width: '8',
  },
  {
    title: '无犯罪记录证明',
    dataIndex: 'innocentEvidenceImage',
    render: (text, record) => (
      <ImagePreview imageLocation={record.无犯罪记录证明} />
    ),
  },
  {
    title: '身份证号码',
    debugtype: 'string',
    dataIndex: 'identityCardNumber',
    width: '22',
  },
  {
    title: '商户',
    dataIndex: 'company',
    render: (text, record) => (record.company ? record.company.id : '暂无'),
  },
  {
    title: '是否可以移车',
    dataIndex: 'availableMoveCar',
    render: (text, record) => (record.availableMoveCar ? '是' : '否'),
  },
  {
    title: '是否可以检车',
    dataIndex: 'availableInspectionCar',
    render: (text, record) => (record.availableInspectionCar ? '是' : '否'),
  },
  {
    title: '是否可以修车',
    dataIndex: 'availableRepairCar',
    render: (text, record) => (record.availableRepairCar ? '是' : '否'),
  },
]

class VehicleServiceCompanyEmployeeViewTable extends PureComponent {
  render() {
    // const { data,count,current, owner } = this.props;
    const { data } = this.props

    return (
      <div className={styles.standardTable}>
        <Table
          rowKey={record => record.id}
          dataSource={data}
          columns={columns}
          size="small"
          pagination={false}
          scroll={{ x: 1080 }}
        />
      </div>
    )
  }
}

export default VehicleServiceCompanyEmployeeViewTable
