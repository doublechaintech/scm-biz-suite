

import React from 'react'
import { Router, Route, Switch } from 'dva/router'
import { LocaleProvider } from 'antd'
import zhCN from 'antd/lib/locale-provider/zh_CN'
// import enUS from 'antd/lib/locale-provider/en_US'
import Launcher from '../launcher/Launcher'
import ForgetPasswordForm from '../launcher/ForgetPasswordForm'

import GlobalComponents from './'


function RouterConfig({ history }) {

	const {HospitalBizApp} = GlobalComponents
	const {ExpenseTypeBizApp} = GlobalComponents
	const {PeriodBizApp} = GlobalComponents
	const {ExpenseItemBizApp} = GlobalComponents
	const {DoctorBizApp} = GlobalComponents
	const {DepartmentBizApp} = GlobalComponents
	const {DoctorAssignmentBizApp} = GlobalComponents
	const {DoctorScheduleBizApp} = GlobalComponents
	const {UserDomainBizApp} = GlobalComponents
	const {UserWhiteListBizApp} = GlobalComponents
	const {SecUserBizApp} = GlobalComponents
	const {SecUserBlockingBizApp} = GlobalComponents
	const {UserAppBizApp} = GlobalComponents
	const {ListAccessBizApp} = GlobalComponents
	const {ObjectAccessBizApp} = GlobalComponents
	const {LoginHistoryBizApp} = GlobalComponents



  return (
    <LocaleProvider locale={zhCN}>
      <Router history={history}>
        <Switch>
         <Route path="/home" component={Launcher} />
         <Route path="/forgetpass" component={ForgetPasswordForm} />
          <Route path="/hospital/" component={HospitalBizApp} />
          <Route path="/expenseType/" component={ExpenseTypeBizApp} />
          <Route path="/period/" component={PeriodBizApp} />
          <Route path="/expenseItem/" component={ExpenseItemBizApp} />
          <Route path="/doctor/" component={DoctorBizApp} />
          <Route path="/department/" component={DepartmentBizApp} />
          <Route path="/doctorAssignment/" component={DoctorAssignmentBizApp} />
          <Route path="/doctorSchedule/" component={DoctorScheduleBizApp} />
          <Route path="/userDomain/" component={UserDomainBizApp} />
          <Route path="/userWhiteList/" component={UserWhiteListBizApp} />
          <Route path="/secUser/" component={SecUserBizApp} />
          <Route path="/secUserBlocking/" component={SecUserBlockingBizApp} />
          <Route path="/userApp/" component={UserAppBizApp} />
          <Route path="/listAccess/" component={ListAccessBizApp} />
          <Route path="/objectAccess/" component={ObjectAccessBizApp} />
          <Route path="/loginHistory/" component={LoginHistoryBizApp} />
         <Route path="/" component={Launcher} />
        </Switch>
      </Router>
    </LocaleProvider>
  )
}

export default RouterConfig










