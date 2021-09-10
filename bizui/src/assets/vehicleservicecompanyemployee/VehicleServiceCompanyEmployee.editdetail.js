import React, { Component } from 'react'
import { connect } from 'dva'
import {
  Form,
  Button,
  Row,
  Col,
  Icon,
  Card,
  Tabs,
  Table,
  Radio,
  DatePicker,
  Tooltip,
  Menu,
  Dropdown,
} from 'antd'
import { Link, Route, Redirect, Switch } from 'dva/router'
import numeral from 'numeral'
import {
  ChartCard,
  yuan,
  MiniArea,
  MiniBar,
  MiniProgress,
  Field,
  Bar,
  Pie,
  TimelineChart,
} from '../../components/Charts'
import Trend from '../../components/Trend'
import NumberInfo from '../../components/NumberInfo'
import { getTimeDistance } from '../../utils/utils'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './VehicleServiceCompanyEmployee.editdetail.less'
import GlobalComponents from '../../custcomponents'

const { TabPane } = Tabs
const { RangePicker } = DatePicker

const topColResponsiveProps = {
  xs: 24,
  sm: 12,
  md: 12,
  lg: 12,
  xl: 6,
  style: { marginBottom: 24 },
}

@connect(state => ({
  vehicleServiceCompanyEmployee: state._vehicleServiceCompanyEmployee,
}))
export default class VehicleServiceCompanyEmployeeEditDetail extends Component {
  state = {
    tabKey: 'employeeDrivingLicenseList',
    stepDirection: 'horizontal',
  }
  onOperationTabChange = key => {
    this.setState({ tabKey: key })
  }

  render() {
    const { EmployeeDrivingLicenseEditTable } = GlobalComponents
    const { CompanyEmployeeMessageEditTable } = GlobalComponents
    const { VehicleInspectionOrderServiceLogEditTable } = GlobalComponents
    const { ServiceVehicleMovementC2mEditTable } = GlobalComponents
    const { ServiceVehicleMovementM2mEditTable } = GlobalComponents
    const { ServiceVehicleMovementM2cEditTable } = GlobalComponents
    const { ServiceFileMovementC2mEditTable } = GlobalComponents
    const { ServiceFileMovementM2mEditTable } = GlobalComponents
    const { ServiceFileMovementM2cEditTable } = GlobalComponents
    const { ServiceInsuranceForInspectionEditTable } = GlobalComponents
    const { ServiceVehicleInspectionEditTable } = GlobalComponents
    const { ServiceFileInspectionEditTable } = GlobalComponents
    const { ServiceVehicleRepairingEditTable } = GlobalComponents

    // eslint-disable-next-line max-len
    const {
      id,
      employeeDrivingLicenseCount,
      companyEmployeeMessageAsSenderCount,
      companyEmployeeMessageAsReceiverCount,
      vehicleInspectionOrderServiceLogCount,
      serviceVehicleMovementC2mCount,
      serviceVehicleMovementM2mAsResponsibleWorkerCount,
      serviceVehicleMovementM2mAsDriverCount,
      serviceVehicleMovementM2mAsReceiverCount,
      serviceVehicleMovementM2cCount,
      serviceFileMovementC2mCount,
      serviceFileMovementM2mAsResponsibleWorkerCount,
      serviceFileMovementM2mAsSenderCount,
      serviceFileMovementM2mAsReceiverCount,
      serviceFileMovementM2cCount,
      serviceInsuranceForInspectionCount,
      serviceVehicleInspectionCount,
      serviceFileInspectionCount,
      serviceVehicleRepairingCount,
    } = this.props.vehicleServiceCompanyEmployee
    const {
      employeeDrivingLicenseList,
      companyEmployeeMessageListAsSender,
      companyEmployeeMessageListAsReceiver,
      vehicleInspectionOrderServiceLogList,
      serviceVehicleMovementC2mList,
      serviceVehicleMovementM2mListAsResponsibleWorker,
      serviceVehicleMovementM2mListAsDriver,
      serviceVehicleMovementM2mListAsReceiver,
      serviceVehicleMovementM2cList,
      serviceFileMovementC2mList,
      serviceFileMovementM2mListAsResponsibleWorker,
      serviceFileMovementM2mListAsSender,
      serviceFileMovementM2mListAsReceiver,
      serviceFileMovementM2cList,
      serviceInsuranceForInspectionList,
      serviceVehicleInspectionList,
      serviceFileInspectionList,
      serviceVehicleRepairingList,
    } = this.props.vehicleServiceCompanyEmployee

    const owner = { type: '_vehicleServiceCompanyEmployee', id }

    const tabList = [
      {
        key: 'employeeDrivingLicenseList',
        tab: '员工驾驶证列表',
      },
      {
        key: 'companyEmployeeMessageListAsSender',
        tab: '消息管理列表',
      },
      {
        key: 'companyEmployeeMessageListAsSender1',
        tab: '消息管理列表',
      },
      {
        key: 'companyEmployeeMessageListAsS2ender',
        tab: '消息管理列表',
      },
      {
        key: 'companyEmployeeMessageListA4Sender',
        tab: '消息管理列表',
      },
      {
        key: 'companyEmployeeMessageList5AsSender',
        tab: '消息管理列表',
      },
      {
        key: 'companyEmployeeMessage6ListAsSender',
        tab: '消息管理列表',
      },
      {
        key: 'companyEmployeeMessa7geListAsSender',
        tab: '消息管理列表',
      },
      {
        key: 'companyEmployeeMes3sageListAsSender',
        tab: '消息管理列表',
      },
      {
        key: 'companyEmployeeMess4ageListAsSender',
        tab: '消息管理列表',
      },
      {
        key: 'companyEmployeeMess3ageListAsSender',
        tab: '消息管理列表',
      },
      {
        key: 'companyEmployee3MessageListAsSender',
        tab: '消息管理列表',
      },
      {
        key: 'companyEmploy3eeMessageListAsSender',
        tab: '消息管理列表',
      },
      {
        key: 'companyEmp3loyeeMessageListAsSender',
        tab: '消息管理列表',
      },
    ]

    const contentList = {
      employeeDrivingLicenseList: (
        <Form layout="vertical" hideRequiredMark>
          <EmployeeDrivingLicenseEditTable
            data={employeeDrivingLicenseList}
            owner={owner}
            {...this.props}
          />
        </Form>
      ),
      companyEmployeeMessageListAsSender: (
        <Form layout="vertical" hideRequiredMark>
          <CompanyEmployeeMessageEditTable
            data={companyEmployeeMessageListAsSender}
            owner={owner}
            {...this.props}
          />
        </Form>
      ),
    }
    return (
      <PageHeaderLayout
        title="服务提供商员工管理总览"
        content="服务提供商员工管理总览"
        wrapperClassName={styles.advancedForm}
      >
        <Card
          className={styles.card}
          bordered={false}
          tabList={tabList}
          onTabChange={this.onOperationTabChange}
        >
          {contentList[this.state.tabKey]}
        </Card>
      </PageHeaderLayout>
    )
  }
}
