import React, { PureComponent } from 'react'
import moment from 'moment'
import {
  Form,
  Button,
  Table,
  Alert,
  Badge,
  Input,
  Divider,
  Popconfirm,
} from 'antd'
import styles from './VehicleServiceCompanyEmployee.edittable.less'
import ImagePreview from '../../components/ImagePreview'

const getRowById = (data, id) => {
  return data.filter(item => item.id === id)[0]
}

const toggleEdit = (e, data, id) => {
  const row = data.filter(item => item.id === id)[0]
  row[editable] = true
}

class VehicleServiceCompanyEmployeeEditTable extends PureComponent {
  constructor(props) {
    super(props)
    console.log(props)
    this.state = {
      data: props.data,
    }
  }

  componentWillReceiveProps(nextProps) {
    const { data } = nextProps
    this.setState({
      data: data,
    })
  }

  render() {
    // const { data,count,current, owner } = this.props
    const { data } = this.state
    const { appendInProcess } = this.state

    const changeText = (e, fieldName, record) => {
      const newData = [...this.state.data]

      const row = getRowById(newData, record.id)
      console.log('text is changed row', row)
      if (row) {
        row[fieldName] = e.target.value
        this.setState({ data: newData })
      }
    }

    const toggleEdit = (e, record) => {
      const newData = [...this.state.data]
      const row = newData.filter(item => item.id === record.id)[0]
      row.editable = !row.editable
      this.setState({ data: newData })
    }
    const removeFromArray = (array, element) => {
      const index = array.indexOf(element)
      console.log('remove from array')
      if (index !== -1) {
        console.log('-------------remove from array')
        array.splice(index, 1)
      }
    }
    const cancelAppend = (e, record) => {
      const newData = [...this.state.data]
      removeFromArray(newData, record)
      this.setState({ data: newData, appendInProcess: false })
    }
    const remapReference = record => {
      const companyId = record.company.id

      //const communityId = record.community.id;
      return { companyId }
    }
    const deleteRecord = (e, record) => {
      const { dispatch, owner } = this.props
      const { data } = this.state
      const vehicleServiceCompanyEmployeeIds = [record.id]
      const parameters = { vehicleServiceCompanyEmployeeIds }
      dispatch({
        type: `${owner.type}/removeVehicleServiceCompanyEmployeeList`,
        payload: {
          id: owner.id,
          type: 'vehicleServiceCompanyEmployee',
          parameters,
        },
      })
    }

    const addRecord = (e, record) => {
      const { dispatch, owner } = this.props
      const { data } = this.state
      const communityId = record.community.id
      const parameters = { ...record, ...remapReference(record) }
      const newData = [...data]

      dispatch({
        type: `${owner.type}/addVehicleServiceCompanyEmployee`,
        payload: {
          id: owner.id,
          type: 'vehicleServiceCompanyEmployee',
          parameters,
          selectedRows: newData,
          currentUpdateIndex: 0,
          continueNext: true,
        },
      })
      this.setState({ appendInProcess: false })
    }

    const updateRecord = (e, record) => {
      const { dispatch, owner } = this.props
      const { data } = this.state
      const { vehicleServiceCompanyEmployeeId } = record.id
      const parameters = { ...record, vehicleServiceCompanyEmployeeId }
      const newData = [...data]
      const row = newData.filter(item => item.id === record.id)[0]
      row.editable = !row.editable

      dispatch({
        type: `${owner.type}/updateVehicleServiceCompanyEmployee`,
        payload: {
          id: owner.id,
          type: 'vehicleServiceCompanyEmployee',
          parameters,
          selectedRows: newData,
          currentUpdateIndex: 0,
          continueNext: true,
        },
      })
    }

    const isAppendingRow = record => {
      return appendInProcess && record.id.indexOf('+') === 0
    }

    const renderStringEdit = (name, text, record) => {
      if (isAppendingRow(record)) {
        return (
          <Input
            size={'small'}
            style={{ width: '80%' }}
            value={text}
            onChange={e => changeText(e, name, record)}
            placeholder={'NO'}
          />
        )
      }
      if (record.editable) {
        return (
          <Input
            size={'small'}
            style={{ width: '80%' }}
            value={text}
            onChange={e => changeText(e, name, record)}
            placeholder={'NO'}
          />
        )
      }
      return text
    }

    const renderActions = (text, record) => {
      if (isAppendingRow(record)) {
        return (
          <div>
            <a onClick={e => addRecord(e, record)}>增加</a>
            <Divider type="vertical" />
            <a onClick={e => cancelAppend(e, record)}>取消</a>
          </div>
        )
      }
      if (record.editable) {
        return (
          <div>
            <a onClick={e => updateRecord(e, record)}>保存</a>
            <Divider type="vertical" />
            <a onClick={e => toggleEdit(e, record)}>取消</a>
          </div>
        )
      }
      return (
        <div>
          <a onClick={e => toggleEdit(e, record)}>编辑</a>
          <Divider type="vertical" />
          <Popconfirm
            title="是否要删除此行？"
            onConfirm={e => deleteRecord(e, record)}
          >
            <a>删除</a>
          </Popconfirm>{' '}
        </div>
      )
    }

    const columns = [
      { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20' },
      {
        title: '员工的名字',
        debugtype: 'string',
        dataIndex: 'employeeName',
        width: '7',
        render: (text, record) =>
          renderStringEdit('employeeName', text, record),
      },
      {
        title: '证件照片',
        dataIndex: 'profileImage',
        render: (text, record) => (
          <ImagePreview imageLocation={record.证件照片} />
        ),
      },
      {
        title: '性别',
        debugtype: 'string_gender',
        dataIndex: 'gender',
        width: '5',
        render: (text, record) => renderStringEdit('gender', text, record),
      },
      {
        title: '工作状态',
        debugtype: 'string',
        dataIndex: 'availableState',
        width: '8',
        render: (text, record) =>
          renderStringEdit('availableState', text, record),
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
        render: (text, record) =>
          renderStringEdit('identityCardNumber', text, record),
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
      {
        title: '操作',
        render: (text, record) => renderActions(text, record),
      },
    ]

    const newRecord = () => {
      const newVehicleServiceCompanyEmployeeToAppend = {
        id: `+1`,
        employeeName: '',
        profileImage: '',
        gender: '',
        availableState: '',
        innocentEvidenceImage: '',
        identityCardNumber: '',
        company: '',
        availableMoveCar: '',
        availableInspectionCar: '',
        availableRepairCar: '',
      }
      const newData = data ? [...data] : []
      newData.push(newVehicleServiceCompanyEmployeeToAppend)
      this.setState({ data: newData, appendInProcess: true })
    }

    return (
      <div className={styles.standardTable}>
        <Table
          rowKey={record => record.id}
          dataSource={data}
          columns={columns}
          size="small"
          pagination={false}
          scroll={{ x: 800 }}
        />

        {!appendInProcess && (
          <Button
            style={{ width: '100%', marginTop: 16, marginBottom: 8 }}
            type="dashed"
            onClick={newRecord}
            icon="plus"
          >
            新增
          </Button>
        )}
      </div>
    )
  }
}

export default Form.create()(VehicleServiceCompanyEmployeeEditTable)
