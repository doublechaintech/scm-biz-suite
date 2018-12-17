import React from 'react'
import PropTypes from 'prop-types'
import { Layout, Menu, Icon, Avatar, Dropdown, Tag, message, Spin } from 'antd'
import DocumentTitle from 'react-document-title'
import { connect } from 'dva'
import { Link, Route, Redirect, Switch } from 'dva/router'
import moment from 'moment'
import groupBy from 'lodash/groupBy'
import { ContainerQuery } from 'react-container-query'
import classNames from 'classnames'
import styles from './VehicleServiceCompanyEmployee.app.less'
import VehicleServiceCompanyEmployeeDashboard from './VehicleServiceCompanyEmployee.dashboard'
import VehicleServiceCompanyEmployeeEditDetail from './VehicleServiceCompanyEmployee.editdetail'
import VehicleServiceCompanyEmployeeViewDetail from './VehicleServiceCompanyEmployee.viewdetail'

import HeaderSearch from '../../components/HeaderSearch'
import NoticeIcon from '../../components/NoticeIcon'
import GlobalFooter from '../../components/GlobalFooter'

import GlobalComponents from '../../custcomponents'

const { Header, Sider, Content } = Layout
const { SubMenu } = Menu

const query = {
  'screen-xs': {
    maxWidth: 575,
  },
  'screen-sm': {
    minWidth: 576,
    maxWidth: 767,
  },
  'screen-md': {
    minWidth: 768,
    maxWidth: 991,
  },
  'screen-lg': {
    minWidth: 992,
    maxWidth: 1199,
  },
  'screen-xl': {
    minWidth: 1200,
  },
}

class VehicleServiceCompanyEmployeeBizApp extends React.PureComponent {
  constructor(props) {
    super(props)
    // 把一级 Layout 的 children 作为菜单项
    // this.menus = getNavData().reduce((arr, current) => arr.concat(current.children), [])
    this.state = {
      openKeys: this.getDefaultCollapsedSubMenus(props),
    }
  }

  componentDidMount() {}
  componentWillUnmount() {
    clearTimeout(this.resizeTimeout)
  }
  onCollapse = collapsed => {
    this.props.dispatch({
      type: 'global/changeLayoutCollapsed',
      payload: collapsed,
    })
  }

  getDefaultCollapsedSubMenus = props => {
    const currentMenuSelectedKeys = [...this.getCurrentMenuSelectedKeys(props)]
    currentMenuSelectedKeys.splice(-1, 1)
    if (currentMenuSelectedKeys.length === 0) {
      return ['/vehicleServiceCompanyEmployee/']
    }
    return currentMenuSelectedKeys
  }
  getCurrentMenuSelectedKeys = props => {
    const { location: { pathname } } = props || this.props
    const keys = pathname.split('/').slice(1)
    if (keys.length === 1 && keys[0] === '') {
      return [this.menus[0].key]
    }
    return keys
  }
  getNavMenuItems = objectId => {
    return (
      <SubMenu
        title={
          <span>
            <Icon type="profile" />
            <span>服务提供商员工管理</span>
          </span>
        }
      >
        <Menu.Item>
          <Link
            to={`/vehicleServiceCompanyEmployee/${objectId}/list/employeeDrivingLicenseList`}
          >
            员工驾驶证
          </Link>
        </Menu.Item>
        <Menu.Item>
          <Link
            to={`/vehicleServiceCompanyEmployee/${objectId}/list/companyEmployeeMessageListAsSender`}
          >
            消息管理
          </Link>
        </Menu.Item>
        <Menu.Item>
          <Link
            to={`/vehicleServiceCompanyEmployee/${objectId}/list/companyEmployeeMessageListAsReceiver`}
          >
            消息管理
          </Link>
        </Menu.Item>
        <Menu.Item>
          <Link
            to={`/vehicleServiceCompanyEmployee/${objectId}/list/vehicleInspectionOrderServiceLogList`}
          >
            车辆检测服务订单日志
          </Link>
        </Menu.Item>
        <Menu.Item>
          <Link
            to={`/vehicleServiceCompanyEmployee/${objectId}/list/serviceVehicleMovementC2mList`}
          >
            收车服务
          </Link>
        </Menu.Item>
        <Menu.Item>
          <Link
            to={`/vehicleServiceCompanyEmployee/${objectId}/list/serviceVehicleMovementM2mListAsResponsibleWorker`}
          >
            送审服务
          </Link>
        </Menu.Item>
        <Menu.Item>
          <Link
            to={`/vehicleServiceCompanyEmployee/${objectId}/list/serviceVehicleMovementM2mListAsDriver`}
          >
            送审服务
          </Link>
        </Menu.Item>
        <Menu.Item>
          <Link
            to={`/vehicleServiceCompanyEmployee/${objectId}/list/serviceVehicleMovementM2mListAsReceiver`}
          >
            送审服务
          </Link>
        </Menu.Item>
        <Menu.Item>
          <Link
            to={`/vehicleServiceCompanyEmployee/${objectId}/list/serviceVehicleMovementM2cList`}
          >
            还车服务
          </Link>
        </Menu.Item>
        <Menu.Item>
          <Link
            to={`/vehicleServiceCompanyEmployee/${objectId}/list/serviceFileMovementC2mList`}
          >
            收件服务
          </Link>
        </Menu.Item>
        <Menu.Item>
          <Link
            to={`/vehicleServiceCompanyEmployee/${objectId}/list/serviceFileMovementM2mListAsResponsibleWorker`}
          >
            移件服务
          </Link>
        </Menu.Item>
        <Menu.Item>
          <Link
            to={`/vehicleServiceCompanyEmployee/${objectId}/list/serviceFileMovementM2mListAsSender`}
          >
            移件服务
          </Link>
        </Menu.Item>
        <Menu.Item>
          <Link
            to={`/vehicleServiceCompanyEmployee/${objectId}/list/serviceFileMovementM2mListAsReceiver`}
          >
            移件服务
          </Link>
        </Menu.Item>
        <Menu.Item>
          <Link
            to={`/vehicleServiceCompanyEmployee/${objectId}/list/serviceFileMovementM2cList`}
          >
            还件服务
          </Link>
        </Menu.Item>
        <Menu.Item>
          <Link
            to={`/vehicleServiceCompanyEmployee/${objectId}/list/serviceInsuranceForInspectionList`}
          >
            保险增值服务
          </Link>
        </Menu.Item>
        <Menu.Item>
          <Link
            to={`/vehicleServiceCompanyEmployee/${objectId}/list/serviceVehicleInspectionList`}
          >
            车辆上线检测结果
          </Link>
        </Menu.Item>
        <Menu.Item>
          <Link
            to={`/vehicleServiceCompanyEmployee/${objectId}/list/serviceFileInspectionList`}
          >
            6年免检服务结果
          </Link>
        </Menu.Item>
        <Menu.Item>
          <Link
            to={`/vehicleServiceCompanyEmployee/${objectId}/list/serviceVehicleRepairingList`}
          >
            修车服务
          </Link>
        </Menu.Item>
      </SubMenu>
    )
  }

  getEmployeeDrivingLicenseSearch = () => {
    const { EmployeeDrivingLicenseSearch } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data: state._vehicleServiceCompanyEmployee.employeeDrivingLicenseList,
      count: state._vehicleServiceCompanyEmployee.employeeDrivingLicenseCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .employeeDrivingLicenseCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .employeeDrivingLicenseSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'employeeDrivingLicenseList',
      }, // this is for model namespace and
    }))(EmployeeDrivingLicenseSearch)
  }
  getEmployeeDrivingLicenseCreateForm = () => {
    const { EmployeeDrivingLicenseCreateForm } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data: state._vehicleServiceCompanyEmployee.employeeDrivingLicenseList,
      count: state._vehicleServiceCompanyEmployee.employeeDrivingLicenseCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .employeeDrivingLicenseCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .employeeDrivingLicenseSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'employeeDrivingLicenseList',
      }, // this is for model namespace and
    }))(EmployeeDrivingLicenseCreateForm)
  }

  getEmployeeDrivingLicenseUpdateForm = () => {
    const { EmployeeDrivingLicenseUpdateForm } = GlobalComponents
    return connect(state => ({
      selectedRows: state._vehicleServiceCompanyEmployee.selectedRows,
      currentUpdateIndex:
        state._vehicleServiceCompanyEmployee.currentUpdateIndex,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'employeeDrivingLicenseList',
      }, // this is for model namespace and
    }))(EmployeeDrivingLicenseUpdateForm)
  }

  getCompanyEmployeeMessageAsSenderSearch = () => {
    const { CompanyEmployeeMessageSearch } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data:
        state._vehicleServiceCompanyEmployee.companyEmployeeMessageListAsSender,
      count:
        state._vehicleServiceCompanyEmployee
          .companyEmployeeMessageAsSenderCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .companyEmployeeMessageAsSenderCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .companyEmployeeMessageAsSenderSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'companyEmployeeMessageListAsSender',
      }, // this is for model namespace and
    }))(CompanyEmployeeMessageSearch)
  }
  getCompanyEmployeeMessageAsSenderCreateForm = () => {
    const { CompanyEmployeeMessageCreateForm } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data:
        state._vehicleServiceCompanyEmployee.companyEmployeeMessageListAsSender,
      count:
        state._vehicleServiceCompanyEmployee
          .companyEmployeeMessageAsSenderCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .companyEmployeeMessageAsSenderCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .companyEmployeeMessageAsSenderSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'companyEmployeeMessageListAsSender',
      }, // this is for model namespace and
    }))(CompanyEmployeeMessageCreateForm)
  }

  getCompanyEmployeeMessageAsSenderUpdateForm = () => {
    const { CompanyEmployeeMessageUpdateForm } = GlobalComponents
    return connect(state => ({
      selectedRows: state._vehicleServiceCompanyEmployee.selectedRows,
      currentUpdateIndex:
        state._vehicleServiceCompanyEmployee.currentUpdateIndex,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'companyEmployeeMessageListAsSender',
      }, // this is for model namespace and
    }))(CompanyEmployeeMessageUpdateForm)
  }

  getCompanyEmployeeMessageAsReceiverSearch = () => {
    const { CompanyEmployeeMessageSearch } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data:
        state._vehicleServiceCompanyEmployee
          .companyEmployeeMessageListAsReceiver,
      count:
        state._vehicleServiceCompanyEmployee
          .companyEmployeeMessageAsReceiverCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .companyEmployeeMessageAsReceiverCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .companyEmployeeMessageAsReceiverSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'companyEmployeeMessageListAsReceiver',
      }, // this is for model namespace and
    }))(CompanyEmployeeMessageSearch)
  }
  getCompanyEmployeeMessageAsReceiverCreateForm = () => {
    const { CompanyEmployeeMessageCreateForm } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data:
        state._vehicleServiceCompanyEmployee
          .companyEmployeeMessageListAsReceiver,
      count:
        state._vehicleServiceCompanyEmployee
          .companyEmployeeMessageAsReceiverCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .companyEmployeeMessageAsReceiverCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .companyEmployeeMessageAsReceiverSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'companyEmployeeMessageListAsReceiver',
      }, // this is for model namespace and
    }))(CompanyEmployeeMessageCreateForm)
  }

  getCompanyEmployeeMessageAsReceiverUpdateForm = () => {
    const { CompanyEmployeeMessageUpdateForm } = GlobalComponents
    return connect(state => ({
      selectedRows: state._vehicleServiceCompanyEmployee.selectedRows,
      currentUpdateIndex:
        state._vehicleServiceCompanyEmployee.currentUpdateIndex,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'companyEmployeeMessageListAsReceiver',
      }, // this is for model namespace and
    }))(CompanyEmployeeMessageUpdateForm)
  }

  getVehicleInspectionOrderServiceLogSearch = () => {
    const { VehicleInspectionOrderServiceLogSearch } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data:
        state._vehicleServiceCompanyEmployee
          .vehicleInspectionOrderServiceLogList,
      count:
        state._vehicleServiceCompanyEmployee
          .vehicleInspectionOrderServiceLogCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .vehicleInspectionOrderServiceLogCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .vehicleInspectionOrderServiceLogSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'vehicleInspectionOrderServiceLogList',
      }, // this is for model namespace and
    }))(VehicleInspectionOrderServiceLogSearch)
  }
  getVehicleInspectionOrderServiceLogCreateForm = () => {
    const { VehicleInspectionOrderServiceLogCreateForm } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data:
        state._vehicleServiceCompanyEmployee
          .vehicleInspectionOrderServiceLogList,
      count:
        state._vehicleServiceCompanyEmployee
          .vehicleInspectionOrderServiceLogCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .vehicleInspectionOrderServiceLogCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .vehicleInspectionOrderServiceLogSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'vehicleInspectionOrderServiceLogList',
      }, // this is for model namespace and
    }))(VehicleInspectionOrderServiceLogCreateForm)
  }

  getVehicleInspectionOrderServiceLogUpdateForm = () => {
    const { VehicleInspectionOrderServiceLogUpdateForm } = GlobalComponents
    return connect(state => ({
      selectedRows: state._vehicleServiceCompanyEmployee.selectedRows,
      currentUpdateIndex:
        state._vehicleServiceCompanyEmployee.currentUpdateIndex,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'vehicleInspectionOrderServiceLogList',
      }, // this is for model namespace and
    }))(VehicleInspectionOrderServiceLogUpdateForm)
  }

  getServiceVehicleMovementC2mSearch = () => {
    const { ServiceVehicleMovementC2mSearch } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data: state._vehicleServiceCompanyEmployee.serviceVehicleMovementC2mList,
      count:
        state._vehicleServiceCompanyEmployee.serviceVehicleMovementC2mCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementC2mCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementC2mSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceVehicleMovementC2mList',
      }, // this is for model namespace and
    }))(ServiceVehicleMovementC2mSearch)
  }
  getServiceVehicleMovementC2mCreateForm = () => {
    const { ServiceVehicleMovementC2mCreateForm } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data: state._vehicleServiceCompanyEmployee.serviceVehicleMovementC2mList,
      count:
        state._vehicleServiceCompanyEmployee.serviceVehicleMovementC2mCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementC2mCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementC2mSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceVehicleMovementC2mList',
      }, // this is for model namespace and
    }))(ServiceVehicleMovementC2mCreateForm)
  }

  getServiceVehicleMovementC2mUpdateForm = () => {
    const { ServiceVehicleMovementC2mUpdateForm } = GlobalComponents
    return connect(state => ({
      selectedRows: state._vehicleServiceCompanyEmployee.selectedRows,
      currentUpdateIndex:
        state._vehicleServiceCompanyEmployee.currentUpdateIndex,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceVehicleMovementC2mList',
      }, // this is for model namespace and
    }))(ServiceVehicleMovementC2mUpdateForm)
  }

  getServiceVehicleMovementM2mAsResponsibleWorkerSearch = () => {
    const { ServiceVehicleMovementM2mSearch } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2mListAsResponsibleWorker,
      count:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2mAsResponsibleWorkerCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2mAsResponsibleWorkerCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2mAsResponsibleWorkerSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceVehicleMovementM2mListAsResponsibleWorker',
      }, // this is for model namespace and
    }))(ServiceVehicleMovementM2mSearch)
  }
  getServiceVehicleMovementM2mAsResponsibleWorkerCreateForm = () => {
    const { ServiceVehicleMovementM2mCreateForm } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2mListAsResponsibleWorker,
      count:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2mAsResponsibleWorkerCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2mAsResponsibleWorkerCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2mAsResponsibleWorkerSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceVehicleMovementM2mListAsResponsibleWorker',
      }, // this is for model namespace and
    }))(ServiceVehicleMovementM2mCreateForm)
  }

  getServiceVehicleMovementM2mAsResponsibleWorkerUpdateForm = () => {
    const { ServiceVehicleMovementM2mUpdateForm } = GlobalComponents
    return connect(state => ({
      selectedRows: state._vehicleServiceCompanyEmployee.selectedRows,
      currentUpdateIndex:
        state._vehicleServiceCompanyEmployee.currentUpdateIndex,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceVehicleMovementM2mListAsResponsibleWorker',
      }, // this is for model namespace and
    }))(ServiceVehicleMovementM2mUpdateForm)
  }

  getServiceVehicleMovementM2mAsDriverSearch = () => {
    const { ServiceVehicleMovementM2mSearch } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2mListAsDriver,
      count:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2mAsDriverCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2mAsDriverCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2mAsDriverSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceVehicleMovementM2mListAsDriver',
      }, // this is for model namespace and
    }))(ServiceVehicleMovementM2mSearch)
  }
  getServiceVehicleMovementM2mAsDriverCreateForm = () => {
    const { ServiceVehicleMovementM2mCreateForm } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2mListAsDriver,
      count:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2mAsDriverCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2mAsDriverCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2mAsDriverSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceVehicleMovementM2mListAsDriver',
      }, // this is for model namespace and
    }))(ServiceVehicleMovementM2mCreateForm)
  }

  getServiceVehicleMovementM2mAsDriverUpdateForm = () => {
    const { ServiceVehicleMovementM2mUpdateForm } = GlobalComponents
    return connect(state => ({
      selectedRows: state._vehicleServiceCompanyEmployee.selectedRows,
      currentUpdateIndex:
        state._vehicleServiceCompanyEmployee.currentUpdateIndex,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceVehicleMovementM2mListAsDriver',
      }, // this is for model namespace and
    }))(ServiceVehicleMovementM2mUpdateForm)
  }

  getServiceVehicleMovementM2mAsReceiverSearch = () => {
    const { ServiceVehicleMovementM2mSearch } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2mListAsReceiver,
      count:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2mAsReceiverCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2mAsReceiverCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2mAsReceiverSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceVehicleMovementM2mListAsReceiver',
      }, // this is for model namespace and
    }))(ServiceVehicleMovementM2mSearch)
  }
  getServiceVehicleMovementM2mAsReceiverCreateForm = () => {
    const { ServiceVehicleMovementM2mCreateForm } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2mListAsReceiver,
      count:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2mAsReceiverCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2mAsReceiverCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2mAsReceiverSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceVehicleMovementM2mListAsReceiver',
      }, // this is for model namespace and
    }))(ServiceVehicleMovementM2mCreateForm)
  }

  getServiceVehicleMovementM2mAsReceiverUpdateForm = () => {
    const { ServiceVehicleMovementM2mUpdateForm } = GlobalComponents
    return connect(state => ({
      selectedRows: state._vehicleServiceCompanyEmployee.selectedRows,
      currentUpdateIndex:
        state._vehicleServiceCompanyEmployee.currentUpdateIndex,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceVehicleMovementM2mListAsReceiver',
      }, // this is for model namespace and
    }))(ServiceVehicleMovementM2mUpdateForm)
  }

  getServiceVehicleMovementM2cSearch = () => {
    const { ServiceVehicleMovementM2cSearch } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data: state._vehicleServiceCompanyEmployee.serviceVehicleMovementM2cList,
      count:
        state._vehicleServiceCompanyEmployee.serviceVehicleMovementM2cCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2cCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2cSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceVehicleMovementM2cList',
      }, // this is for model namespace and
    }))(ServiceVehicleMovementM2cSearch)
  }
  getServiceVehicleMovementM2cCreateForm = () => {
    const { ServiceVehicleMovementM2cCreateForm } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data: state._vehicleServiceCompanyEmployee.serviceVehicleMovementM2cList,
      count:
        state._vehicleServiceCompanyEmployee.serviceVehicleMovementM2cCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2cCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleMovementM2cSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceVehicleMovementM2cList',
      }, // this is for model namespace and
    }))(ServiceVehicleMovementM2cCreateForm)
  }

  getServiceVehicleMovementM2cUpdateForm = () => {
    const { ServiceVehicleMovementM2cUpdateForm } = GlobalComponents
    return connect(state => ({
      selectedRows: state._vehicleServiceCompanyEmployee.selectedRows,
      currentUpdateIndex:
        state._vehicleServiceCompanyEmployee.currentUpdateIndex,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceVehicleMovementM2cList',
      }, // this is for model namespace and
    }))(ServiceVehicleMovementM2cUpdateForm)
  }

  getServiceFileMovementC2mSearch = () => {
    const { ServiceFileMovementC2mSearch } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data: state._vehicleServiceCompanyEmployee.serviceFileMovementC2mList,
      count: state._vehicleServiceCompanyEmployee.serviceFileMovementC2mCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementC2mCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementC2mSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceFileMovementC2mList',
      }, // this is for model namespace and
    }))(ServiceFileMovementC2mSearch)
  }
  getServiceFileMovementC2mCreateForm = () => {
    const { ServiceFileMovementC2mCreateForm } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data: state._vehicleServiceCompanyEmployee.serviceFileMovementC2mList,
      count: state._vehicleServiceCompanyEmployee.serviceFileMovementC2mCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementC2mCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementC2mSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceFileMovementC2mList',
      }, // this is for model namespace and
    }))(ServiceFileMovementC2mCreateForm)
  }

  getServiceFileMovementC2mUpdateForm = () => {
    const { ServiceFileMovementC2mUpdateForm } = GlobalComponents
    return connect(state => ({
      selectedRows: state._vehicleServiceCompanyEmployee.selectedRows,
      currentUpdateIndex:
        state._vehicleServiceCompanyEmployee.currentUpdateIndex,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceFileMovementC2mList',
      }, // this is for model namespace and
    }))(ServiceFileMovementC2mUpdateForm)
  }

  getServiceFileMovementM2mAsResponsibleWorkerSearch = () => {
    const { ServiceFileMovementM2mSearch } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2mListAsResponsibleWorker,
      count:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2mAsResponsibleWorkerCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2mAsResponsibleWorkerCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2mAsResponsibleWorkerSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceFileMovementM2mListAsResponsibleWorker',
      }, // this is for model namespace and
    }))(ServiceFileMovementM2mSearch)
  }
  getServiceFileMovementM2mAsResponsibleWorkerCreateForm = () => {
    const { ServiceFileMovementM2mCreateForm } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2mListAsResponsibleWorker,
      count:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2mAsResponsibleWorkerCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2mAsResponsibleWorkerCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2mAsResponsibleWorkerSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceFileMovementM2mListAsResponsibleWorker',
      }, // this is for model namespace and
    }))(ServiceFileMovementM2mCreateForm)
  }

  getServiceFileMovementM2mAsResponsibleWorkerUpdateForm = () => {
    const { ServiceFileMovementM2mUpdateForm } = GlobalComponents
    return connect(state => ({
      selectedRows: state._vehicleServiceCompanyEmployee.selectedRows,
      currentUpdateIndex:
        state._vehicleServiceCompanyEmployee.currentUpdateIndex,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceFileMovementM2mListAsResponsibleWorker',
      }, // this is for model namespace and
    }))(ServiceFileMovementM2mUpdateForm)
  }

  getServiceFileMovementM2mAsSenderSearch = () => {
    const { ServiceFileMovementM2mSearch } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data:
        state._vehicleServiceCompanyEmployee.serviceFileMovementM2mListAsSender,
      count:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2mAsSenderCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2mAsSenderCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2mAsSenderSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceFileMovementM2mListAsSender',
      }, // this is for model namespace and
    }))(ServiceFileMovementM2mSearch)
  }
  getServiceFileMovementM2mAsSenderCreateForm = () => {
    const { ServiceFileMovementM2mCreateForm } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data:
        state._vehicleServiceCompanyEmployee.serviceFileMovementM2mListAsSender,
      count:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2mAsSenderCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2mAsSenderCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2mAsSenderSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceFileMovementM2mListAsSender',
      }, // this is for model namespace and
    }))(ServiceFileMovementM2mCreateForm)
  }

  getServiceFileMovementM2mAsSenderUpdateForm = () => {
    const { ServiceFileMovementM2mUpdateForm } = GlobalComponents
    return connect(state => ({
      selectedRows: state._vehicleServiceCompanyEmployee.selectedRows,
      currentUpdateIndex:
        state._vehicleServiceCompanyEmployee.currentUpdateIndex,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceFileMovementM2mListAsSender',
      }, // this is for model namespace and
    }))(ServiceFileMovementM2mUpdateForm)
  }

  getServiceFileMovementM2mAsReceiverSearch = () => {
    const { ServiceFileMovementM2mSearch } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2mListAsReceiver,
      count:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2mAsReceiverCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2mAsReceiverCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2mAsReceiverSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceFileMovementM2mListAsReceiver',
      }, // this is for model namespace and
    }))(ServiceFileMovementM2mSearch)
  }
  getServiceFileMovementM2mAsReceiverCreateForm = () => {
    const { ServiceFileMovementM2mCreateForm } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2mListAsReceiver,
      count:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2mAsReceiverCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2mAsReceiverCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2mAsReceiverSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceFileMovementM2mListAsReceiver',
      }, // this is for model namespace and
    }))(ServiceFileMovementM2mCreateForm)
  }

  getServiceFileMovementM2mAsReceiverUpdateForm = () => {
    const { ServiceFileMovementM2mUpdateForm } = GlobalComponents
    return connect(state => ({
      selectedRows: state._vehicleServiceCompanyEmployee.selectedRows,
      currentUpdateIndex:
        state._vehicleServiceCompanyEmployee.currentUpdateIndex,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceFileMovementM2mListAsReceiver',
      }, // this is for model namespace and
    }))(ServiceFileMovementM2mUpdateForm)
  }

  getServiceFileMovementM2cSearch = () => {
    const { ServiceFileMovementM2cSearch } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data: state._vehicleServiceCompanyEmployee.serviceFileMovementM2cList,
      count: state._vehicleServiceCompanyEmployee.serviceFileMovementM2cCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2cCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2cSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceFileMovementM2cList',
      }, // this is for model namespace and
    }))(ServiceFileMovementM2cSearch)
  }
  getServiceFileMovementM2cCreateForm = () => {
    const { ServiceFileMovementM2cCreateForm } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data: state._vehicleServiceCompanyEmployee.serviceFileMovementM2cList,
      count: state._vehicleServiceCompanyEmployee.serviceFileMovementM2cCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2cCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceFileMovementM2cSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceFileMovementM2cList',
      }, // this is for model namespace and
    }))(ServiceFileMovementM2cCreateForm)
  }

  getServiceFileMovementM2cUpdateForm = () => {
    const { ServiceFileMovementM2cUpdateForm } = GlobalComponents
    return connect(state => ({
      selectedRows: state._vehicleServiceCompanyEmployee.selectedRows,
      currentUpdateIndex:
        state._vehicleServiceCompanyEmployee.currentUpdateIndex,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceFileMovementM2cList',
      }, // this is for model namespace and
    }))(ServiceFileMovementM2cUpdateForm)
  }

  getServiceInsuranceForInspectionSearch = () => {
    const { ServiceInsuranceForInspectionSearch } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data:
        state._vehicleServiceCompanyEmployee.serviceInsuranceForInspectionList,
      count:
        state._vehicleServiceCompanyEmployee.serviceInsuranceForInspectionCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceInsuranceForInspectionCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceInsuranceForInspectionSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceInsuranceForInspectionList',
      }, // this is for model namespace and
    }))(ServiceInsuranceForInspectionSearch)
  }
  getServiceInsuranceForInspectionCreateForm = () => {
    const { ServiceInsuranceForInspectionCreateForm } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data:
        state._vehicleServiceCompanyEmployee.serviceInsuranceForInspectionList,
      count:
        state._vehicleServiceCompanyEmployee.serviceInsuranceForInspectionCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceInsuranceForInspectionCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceInsuranceForInspectionSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceInsuranceForInspectionList',
      }, // this is for model namespace and
    }))(ServiceInsuranceForInspectionCreateForm)
  }

  getServiceInsuranceForInspectionUpdateForm = () => {
    const { ServiceInsuranceForInspectionUpdateForm } = GlobalComponents
    return connect(state => ({
      selectedRows: state._vehicleServiceCompanyEmployee.selectedRows,
      currentUpdateIndex:
        state._vehicleServiceCompanyEmployee.currentUpdateIndex,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceInsuranceForInspectionList',
      }, // this is for model namespace and
    }))(ServiceInsuranceForInspectionUpdateForm)
  }

  getServiceVehicleInspectionSearch = () => {
    const { ServiceVehicleInspectionSearch } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data: state._vehicleServiceCompanyEmployee.serviceVehicleInspectionList,
      count: state._vehicleServiceCompanyEmployee.serviceVehicleInspectionCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleInspectionCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleInspectionSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceVehicleInspectionList',
      }, // this is for model namespace and
    }))(ServiceVehicleInspectionSearch)
  }
  getServiceVehicleInspectionCreateForm = () => {
    const { ServiceVehicleInspectionCreateForm } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data: state._vehicleServiceCompanyEmployee.serviceVehicleInspectionList,
      count: state._vehicleServiceCompanyEmployee.serviceVehicleInspectionCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleInspectionCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleInspectionSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceVehicleInspectionList',
      }, // this is for model namespace and
    }))(ServiceVehicleInspectionCreateForm)
  }

  getServiceVehicleInspectionUpdateForm = () => {
    const { ServiceVehicleInspectionUpdateForm } = GlobalComponents
    return connect(state => ({
      selectedRows: state._vehicleServiceCompanyEmployee.selectedRows,
      currentUpdateIndex:
        state._vehicleServiceCompanyEmployee.currentUpdateIndex,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceVehicleInspectionList',
      }, // this is for model namespace and
    }))(ServiceVehicleInspectionUpdateForm)
  }

  getServiceFileInspectionSearch = () => {
    const { ServiceFileInspectionSearch } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data: state._vehicleServiceCompanyEmployee.serviceFileInspectionList,
      count: state._vehicleServiceCompanyEmployee.serviceFileInspectionCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceFileInspectionCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceFileInspectionSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceFileInspectionList',
      }, // this is for model namespace and
    }))(ServiceFileInspectionSearch)
  }
  getServiceFileInspectionCreateForm = () => {
    const { ServiceFileInspectionCreateForm } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data: state._vehicleServiceCompanyEmployee.serviceFileInspectionList,
      count: state._vehicleServiceCompanyEmployee.serviceFileInspectionCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceFileInspectionCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceFileInspectionSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceFileInspectionList',
      }, // this is for model namespace and
    }))(ServiceFileInspectionCreateForm)
  }

  getServiceFileInspectionUpdateForm = () => {
    const { ServiceFileInspectionUpdateForm } = GlobalComponents
    return connect(state => ({
      selectedRows: state._vehicleServiceCompanyEmployee.selectedRows,
      currentUpdateIndex:
        state._vehicleServiceCompanyEmployee.currentUpdateIndex,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceFileInspectionList',
      }, // this is for model namespace and
    }))(ServiceFileInspectionUpdateForm)
  }

  getServiceVehicleRepairingSearch = () => {
    const { ServiceVehicleRepairingSearch } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data: state._vehicleServiceCompanyEmployee.serviceVehicleRepairingList,
      count: state._vehicleServiceCompanyEmployee.serviceVehicleRepairingCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleRepairingCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleRepairingSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceVehicleRepairingList',
      }, // this is for model namespace and
    }))(ServiceVehicleRepairingSearch)
  }
  getServiceVehicleRepairingCreateForm = () => {
    const { ServiceVehicleRepairingCreateForm } = GlobalComponents
    return connect(state => ({
      rule: state.rule,
      data: state._vehicleServiceCompanyEmployee.serviceVehicleRepairingList,
      count: state._vehicleServiceCompanyEmployee.serviceVehicleRepairingCount,
      currentPage:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleRepairingCurrentPageNumber,
      searchFormParameters:
        state._vehicleServiceCompanyEmployee
          .serviceVehicleRepairingSearchFormParameters,
      loading: state._vehicleServiceCompanyEmployee.loading,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceVehicleRepairingList',
      }, // this is for model namespace and
    }))(ServiceVehicleRepairingCreateForm)
  }

  getServiceVehicleRepairingUpdateForm = () => {
    const { ServiceVehicleRepairingUpdateForm } = GlobalComponents
    return connect(state => ({
      selectedRows: state._vehicleServiceCompanyEmployee.selectedRows,
      currentUpdateIndex:
        state._vehicleServiceCompanyEmployee.currentUpdateIndex,
      owner: {
        type: '_vehicleServiceCompanyEmployee',
        id: state._vehicleServiceCompanyEmployee.id,
        listName: 'serviceVehicleRepairingList',
      }, // this is for model namespace and
    }))(ServiceVehicleRepairingUpdateForm)
  }

  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = '代审车服务平台'
    return title
  }

  handleOpenChange = openKeys => {
    const latestOpenKey = openKeys.find(
      key => this.state.openKeys.indexOf(key) === -1
    )
    this.setState({
      openKeys: latestOpenKey ? [latestOpenKey] : [],
    })
  }
  toggle = () => {
    const { collapsed } = this.props
    this.props.dispatch({
      type: 'global/changeLayoutCollapsed',
      payload: !collapsed,
    })
  }

  render() {
    // const { collapsed, fetchingNotices,loading } = this.props
    const { collapsed } = this.props
    // Don't show popup menu when it is been collapsed
    const menuProps = collapsed
      ? {}
      : {
          openKeys: this.state.openKeys,
        }
    const layout = (
      <Layout>
        <Sider
          trigger={null}
          collapsible
          collapsed={collapsed}
          breakpoint="md"
          onCollapse={() => this.onCollapse(collapsed)}
          width={256}
          className={styles.sider}
        >
          <div className={styles.logo}>
            <img src="/scm.svg" alt="logo" onClick={this.toggle} />
            <Link to="/home">
              {' '}
              <h1>服务提供商员工管理</h1>
            </Link>
          </div>

          <Menu
            theme="dark"
            mode="inline"
            {...menuProps}
            onOpenChange={this.handleOpenChange}
            selectedKeys={this.getCurrentMenuSelectedKeys()}
            style={{ margin: '16px 0', width: '100%' }}
          >
            <Menu.Item>
              <Link
                to={`/vehicleServiceCompanyEmployee/${
                  this.props.vehicleServiceCompanyEmployee.id
                }/dashboard`}
              >
                <Icon type="dashboard" />
                <span>仪表板</span>
              </Link>
            </Menu.Item>
            <Menu.Item>
              <Link
                to={`/vehicleServiceCompanyEmployee/${
                  this.props.vehicleServiceCompanyEmployee.id
                }/editDetail`}
              >
                <Icon type="edit" />
                <span>详情编辑</span>
              </Link>
            </Menu.Item>
            <Menu.Item>
              <Link
                to={`/vehicleServiceCompanyEmployee/${
                  this.props.vehicleServiceCompanyEmployee.id
                }/viewDetail`}
              >
                <Icon type="eye-o" />
                <span>详情查看</span>
              </Link>
            </Menu.Item>

            {this.getNavMenuItems(this.props.vehicleServiceCompanyEmployee.id)}
            <Menu.Item>
              <Link to={'/home'}>
                <Icon type="home" />
                <span>回到主页</span>
              </Link>
            </Menu.Item>
          </Menu>
        </Sider>
        <Layout>
          <Content style={{ margin: '24px 24px 0', height: '100%' }}>
            <Switch>
              <Route
                path="/vehicleServiceCompanyEmployee/:id/dashboard"
                component={VehicleServiceCompanyEmployeeDashboard}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/editDetail"
                component={VehicleServiceCompanyEmployeeEditDetail}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/viewDetail"
                component={VehicleServiceCompanyEmployeeViewDetail}
              />

              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/employeeDrivingLicenseList"
                component={this.getEmployeeDrivingLicenseSearch()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/employeeDrivingLicenseCreateForm"
                component={this.getEmployeeDrivingLicenseCreateForm()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/employeeDrivingLicenseUpdateForm"
                component={this.getEmployeeDrivingLicenseUpdateForm()}
              />

              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/companyEmployeeMessageListAsSender"
                component={this.getCompanyEmployeeMessageAsSenderSearch()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/companyEmployeeMessageAsSenderCreateForm"
                component={this.getCompanyEmployeeMessageAsSenderCreateForm()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/companyEmployeeMessageAsSenderUpdateForm"
                component={this.getCompanyEmployeeMessageAsSenderUpdateForm()}
              />

              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/companyEmployeeMessageListAsReceiver"
                component={this.getCompanyEmployeeMessageAsReceiverSearch()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/companyEmployeeMessageAsReceiverCreateForm"
                component={this.getCompanyEmployeeMessageAsReceiverCreateForm()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/companyEmployeeMessageAsReceiverUpdateForm"
                component={this.getCompanyEmployeeMessageAsReceiverUpdateForm()}
              />

              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/vehicleInspectionOrderServiceLogList"
                component={this.getVehicleInspectionOrderServiceLogSearch()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/vehicleInspectionOrderServiceLogCreateForm"
                component={this.getVehicleInspectionOrderServiceLogCreateForm()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/vehicleInspectionOrderServiceLogUpdateForm"
                component={this.getVehicleInspectionOrderServiceLogUpdateForm()}
              />

              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceVehicleMovementC2mList"
                component={this.getServiceVehicleMovementC2mSearch()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceVehicleMovementC2mCreateForm"
                component={this.getServiceVehicleMovementC2mCreateForm()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceVehicleMovementC2mUpdateForm"
                component={this.getServiceVehicleMovementC2mUpdateForm()}
              />

              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceVehicleMovementM2mListAsResponsibleWorker"
                component={this.getServiceVehicleMovementM2mAsResponsibleWorkerSearch()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceVehicleMovementM2mAsResponsibleWorkerCreateForm"
                component={this.getServiceVehicleMovementM2mAsResponsibleWorkerCreateForm()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceVehicleMovementM2mAsResponsibleWorkerUpdateForm"
                component={this.getServiceVehicleMovementM2mAsResponsibleWorkerUpdateForm()}
              />

              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceVehicleMovementM2mListAsDriver"
                component={this.getServiceVehicleMovementM2mAsDriverSearch()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceVehicleMovementM2mAsDriverCreateForm"
                component={this.getServiceVehicleMovementM2mAsDriverCreateForm()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceVehicleMovementM2mAsDriverUpdateForm"
                component={this.getServiceVehicleMovementM2mAsDriverUpdateForm()}
              />

              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceVehicleMovementM2mListAsReceiver"
                component={this.getServiceVehicleMovementM2mAsReceiverSearch()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceVehicleMovementM2mAsReceiverCreateForm"
                component={this.getServiceVehicleMovementM2mAsReceiverCreateForm()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceVehicleMovementM2mAsReceiverUpdateForm"
                component={this.getServiceVehicleMovementM2mAsReceiverUpdateForm()}
              />

              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceVehicleMovementM2cList"
                component={this.getServiceVehicleMovementM2cSearch()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceVehicleMovementM2cCreateForm"
                component={this.getServiceVehicleMovementM2cCreateForm()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceVehicleMovementM2cUpdateForm"
                component={this.getServiceVehicleMovementM2cUpdateForm()}
              />

              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceFileMovementC2mList"
                component={this.getServiceFileMovementC2mSearch()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceFileMovementC2mCreateForm"
                component={this.getServiceFileMovementC2mCreateForm()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceFileMovementC2mUpdateForm"
                component={this.getServiceFileMovementC2mUpdateForm()}
              />

              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceFileMovementM2mListAsResponsibleWorker"
                component={this.getServiceFileMovementM2mAsResponsibleWorkerSearch()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceFileMovementM2mAsResponsibleWorkerCreateForm"
                component={this.getServiceFileMovementM2mAsResponsibleWorkerCreateForm()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceFileMovementM2mAsResponsibleWorkerUpdateForm"
                component={this.getServiceFileMovementM2mAsResponsibleWorkerUpdateForm()}
              />

              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceFileMovementM2mListAsSender"
                component={this.getServiceFileMovementM2mAsSenderSearch()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceFileMovementM2mAsSenderCreateForm"
                component={this.getServiceFileMovementM2mAsSenderCreateForm()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceFileMovementM2mAsSenderUpdateForm"
                component={this.getServiceFileMovementM2mAsSenderUpdateForm()}
              />

              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceFileMovementM2mListAsReceiver"
                component={this.getServiceFileMovementM2mAsReceiverSearch()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceFileMovementM2mAsReceiverCreateForm"
                component={this.getServiceFileMovementM2mAsReceiverCreateForm()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceFileMovementM2mAsReceiverUpdateForm"
                component={this.getServiceFileMovementM2mAsReceiverUpdateForm()}
              />

              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceFileMovementM2cList"
                component={this.getServiceFileMovementM2cSearch()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceFileMovementM2cCreateForm"
                component={this.getServiceFileMovementM2cCreateForm()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceFileMovementM2cUpdateForm"
                component={this.getServiceFileMovementM2cUpdateForm()}
              />

              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceInsuranceForInspectionList"
                component={this.getServiceInsuranceForInspectionSearch()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceInsuranceForInspectionCreateForm"
                component={this.getServiceInsuranceForInspectionCreateForm()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceInsuranceForInspectionUpdateForm"
                component={this.getServiceInsuranceForInspectionUpdateForm()}
              />

              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceVehicleInspectionList"
                component={this.getServiceVehicleInspectionSearch()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceVehicleInspectionCreateForm"
                component={this.getServiceVehicleInspectionCreateForm()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceVehicleInspectionUpdateForm"
                component={this.getServiceVehicleInspectionUpdateForm()}
              />

              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceFileInspectionList"
                component={this.getServiceFileInspectionSearch()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceFileInspectionCreateForm"
                component={this.getServiceFileInspectionCreateForm()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceFileInspectionUpdateForm"
                component={this.getServiceFileInspectionUpdateForm()}
              />

              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceVehicleRepairingList"
                component={this.getServiceVehicleRepairingSearch()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceVehicleRepairingCreateForm"
                component={this.getServiceVehicleRepairingCreateForm()}
              />
              <Route
                path="/vehicleServiceCompanyEmployee/:id/list/serviceVehicleRepairingUpdateForm"
                component={this.getServiceVehicleRepairingUpdateForm()}
              />
            </Switch>
          </Content>
        </Layout>
      </Layout>
    )
    return (
      <DocumentTitle title={this.getPageTitle()}>
        <ContainerQuery query={query}>
          {params => <div className={classNames(params)}>{layout}</div>}
        </ContainerQuery>
      </DocumentTitle>
    )
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
  fetchingNotices: state.global.fetchingNotices,
  notices: state.global.notices,
  vehicleServiceCompanyEmployee: state._vehicleServiceCompanyEmployee,
  ...state,
}))(VehicleServiceCompanyEmployeeBizApp)
