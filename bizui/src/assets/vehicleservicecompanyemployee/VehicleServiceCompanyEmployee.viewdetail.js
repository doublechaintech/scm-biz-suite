import React, { Component } from 'react'
import { connect } from 'dva'
import { Form,Button, Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Steps,Badge } from 'antd'
import { Link, Route, Redirect, Switch } from 'dva/router'
import numeral from 'numeral'
import {
  ChartCard, yuan, MiniArea, MiniBar, MiniProgress, Field, Bar, Pie, TimelineChart,

} from '../../components/Charts'
import Trend from '../../components/Trend'
import NumberInfo from '../../components/NumberInfo'
import { getTimeDistance } from '../../utils/utils'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './VehicleServiceCompanyEmployee.viewdetail.less'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList';
const { Description } = DescriptionList;
const { Step } = Steps

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

const summaryOf = (vehicleServiceCompanyEmployee) =>{

	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{vehicleServiceCompanyEmployee.id}</Description> 
<Description term="员工的名字">{vehicleServiceCompanyEmployee.employeeName}</Description> 
<Description term="证件照片">{vehicleServiceCompanyEmployee.profileImage}</Description> 
<Description term="性别">{vehicleServiceCompanyEmployee.gender}</Description> 
<Description term="工作状态">{vehicleServiceCompanyEmployee.availableState}</Description> 
<Description term="无犯罪记录证明">{vehicleServiceCompanyEmployee.innocentEvidenceImage}</Description> 
<Description term="身份证号码">{vehicleServiceCompanyEmployee.identityCardNumber}</Description> 
<Description term="是否可以移车">{vehicleServiceCompanyEmployee.availableMoveCar?'是':'否'}</Description> 
<Description term="是否可以检车">{vehicleServiceCompanyEmployee.availableInspectionCar?'是':'否'}</Description> 
<Description term="是否可以修车">{vehicleServiceCompanyEmployee.availableRepairCar?'是':'否'}</Description> 
<Description term="当前状态">{vehicleServiceCompanyEmployee.currentStatus}</Description> 
	
        
      </DescriptionList>
  )
  



}



@connect(state => ({
  vehicleServiceCompanyEmployee: state._vehicleServiceCompanyEmployee,
}))
export default class VehicleServiceCompanyEmployeeViewDetail extends Component {


  state = {
    tabKey: `employeeDrivingLicenseList`,
    stepDirection: 'horizontal',
  }
 
  onTabChange = (key) => {
    this.setState({ tabKey: key });
  }  
  render() {
    const {EmployeeDrivingLicenseViewTable} = GlobalComponents;
    const {CompanyEmployeeMessageViewTable} = GlobalComponents;
    const {VehicleInspectionOrderServiceLogViewTable} = GlobalComponents;
    const {ServiceVehicleMovementC2mViewTable} = GlobalComponents;
    const {ServiceVehicleMovementM2mViewTable} = GlobalComponents;
    const {ServiceVehicleMovementM2cViewTable} = GlobalComponents;
    const {ServiceFileMovementC2mViewTable} = GlobalComponents;
    const {ServiceFileMovementM2mViewTable} = GlobalComponents;
    const {ServiceFileMovementM2cViewTable} = GlobalComponents;
    const {ServiceInsuranceForInspectionViewTable} = GlobalComponents;
    const {ServiceVehicleInspectionViewTable} = GlobalComponents;
    const {ServiceFileInspectionViewTable} = GlobalComponents;
    const {ServiceVehicleRepairingViewTable} = GlobalComponents;
  
    // eslint-disable-next-line max-len
    const { id, employeeDrivingLicenseCount, companyEmployeeMessageAsSenderCount, companyEmployeeMessageAsReceiverCount, vehicleInspectionOrderServiceLogCount, serviceVehicleMovementC2mCount, serviceVehicleMovementM2mAsResponsibleWorkerCount, serviceVehicleMovementM2mAsDriverCount, serviceVehicleMovementM2mAsReceiverCount, serviceVehicleMovementM2cCount, serviceFileMovementC2mCount, serviceFileMovementM2mAsResponsibleWorkerCount, serviceFileMovementM2mAsSenderCount, serviceFileMovementM2mAsReceiverCount, serviceFileMovementM2cCount, serviceInsuranceForInspectionCount, serviceVehicleInspectionCount, serviceFileInspectionCount, serviceVehicleRepairingCount } = this.props.vehicleServiceCompanyEmployee
    const { employeeDrivingLicenseList, companyEmployeeMessageListAsSender, companyEmployeeMessageListAsReceiver, vehicleInspectionOrderServiceLogList, serviceVehicleMovementC2mList, serviceVehicleMovementM2mListAsResponsibleWorker, serviceVehicleMovementM2mListAsDriver, serviceVehicleMovementM2mListAsReceiver, serviceVehicleMovementM2cList, serviceFileMovementC2mList, serviceFileMovementM2mListAsResponsibleWorker, serviceFileMovementM2mListAsSender, serviceFileMovementM2mListAsReceiver, serviceFileMovementM2cList, serviceInsuranceForInspectionList, serviceVehicleInspectionList, serviceFileInspectionList, serviceVehicleRepairingList } = this.props.vehicleServiceCompanyEmployee
    
    const owner = { type: '_vehicleServiceCompanyEmployee', id }
 
    
    const tabList = [

      {key: 'employeeDrivingLicenseList',tab: `员工驾驶证(${employeeDrivingLicenseCount})`}, 
      {key: 'companyEmployeeMessageListAsSender',tab: `消息管理(${companyEmployeeMessageAsSenderCount})`}, 
      {key: 'companyEmployeeMessageListAsReceiver',tab: `消息管理(${companyEmployeeMessageAsReceiverCount})`}, 
      {key: 'vehicleInspectionOrderServiceLogList',tab: `车辆检测服务订单日志(${vehicleInspectionOrderServiceLogCount})`}, 
      {key: 'serviceVehicleMovementC2mList',tab: `收车服务(${serviceVehicleMovementC2mCount})`}, 
      {key: 'serviceVehicleMovementM2mListAsResponsibleWorker',tab: `送审服务(${serviceVehicleMovementM2mAsResponsibleWorkerCount})`}, 
      {key: 'serviceVehicleMovementM2mListAsDriver',tab: `送审服务(${serviceVehicleMovementM2mAsDriverCount})`}, 
      {key: 'serviceVehicleMovementM2mListAsReceiver',tab: `送审服务(${serviceVehicleMovementM2mAsReceiverCount})`}, 
      {key: 'serviceVehicleMovementM2cList',tab: `还车服务(${serviceVehicleMovementM2cCount})`}, 
      {key: 'serviceFileMovementC2mList',tab: `收件服务(${serviceFileMovementC2mCount})`}, 
      {key: 'serviceFileMovementM2mListAsResponsibleWorker',tab: `移件服务(${serviceFileMovementM2mAsResponsibleWorkerCount})`}, 
      {key: 'serviceFileMovementM2mListAsSender',tab: `移件服务(${serviceFileMovementM2mAsSenderCount})`}, 
      {key: 'serviceFileMovementM2mListAsReceiver',tab: `移件服务(${serviceFileMovementM2mAsReceiverCount})`}, 
      {key: 'serviceFileMovementM2cList',tab: `还件服务(${serviceFileMovementM2cCount})`}, 
      {key: 'serviceInsuranceForInspectionList',tab: `保险增值服务(${serviceInsuranceForInspectionCount})`}, 
      {key: 'serviceVehicleInspectionList',tab: `车辆上线检测结果(${serviceVehicleInspectionCount})`}, 
      {key: 'serviceFileInspectionList',tab: `6年免检服务结果(${serviceFileInspectionCount})`}, 
      {key: 'serviceVehicleRepairingList',tab: `修车服务(${serviceVehicleRepairingCount})`}, 
   

   ];
   
   
    const contentList = {
       employeeDrivingLicenseList:  
        <EmployeeDrivingLicenseViewTable data={employeeDrivingLicenseList} owner={owner} {...this.props} />,
 
      companyEmployeeMessageListAsSender:  
        <CompanyEmployeeMessageViewTable data={companyEmployeeMessageListAsSender} owner={owner} {...this.props} />,
 
      companyEmployeeMessageListAsReceiver:  
        <CompanyEmployeeMessageViewTable data={companyEmployeeMessageListAsReceiver} owner={owner} {...this.props} />,
 
      vehicleInspectionOrderServiceLogList:  
        <VehicleInspectionOrderServiceLogViewTable data={vehicleInspectionOrderServiceLogList} owner={owner} {...this.props} />,
 
      serviceVehicleMovementC2mList:  
        <ServiceVehicleMovementC2mViewTable data={serviceVehicleMovementC2mList} owner={owner} {...this.props} />,
 
      serviceVehicleMovementM2mListAsResponsibleWorker:  
        <ServiceVehicleMovementM2mViewTable data={serviceVehicleMovementM2mListAsResponsibleWorker} owner={owner} {...this.props} />,
 
      serviceVehicleMovementM2mListAsDriver:  
        <ServiceVehicleMovementM2mViewTable data={serviceVehicleMovementM2mListAsDriver} owner={owner} {...this.props} />,
 
      serviceVehicleMovementM2mListAsReceiver:  
        <ServiceVehicleMovementM2mViewTable data={serviceVehicleMovementM2mListAsReceiver} owner={owner} {...this.props} />,
 
      serviceVehicleMovementM2cList:  
        <ServiceVehicleMovementM2cViewTable data={serviceVehicleMovementM2cList} owner={owner} {...this.props} />,
 
      serviceFileMovementC2mList:  
        <ServiceFileMovementC2mViewTable data={serviceFileMovementC2mList} owner={owner} {...this.props} />,
 
      serviceFileMovementM2mListAsResponsibleWorker:  
        <ServiceFileMovementM2mViewTable data={serviceFileMovementM2mListAsResponsibleWorker} owner={owner} {...this.props} />,
 
      serviceFileMovementM2mListAsSender:  
        <ServiceFileMovementM2mViewTable data={serviceFileMovementM2mListAsSender} owner={owner} {...this.props} />,
 
      serviceFileMovementM2mListAsReceiver:  
        <ServiceFileMovementM2mViewTable data={serviceFileMovementM2mListAsReceiver} owner={owner} {...this.props} />,
 
      serviceFileMovementM2cList:  
        <ServiceFileMovementM2cViewTable data={serviceFileMovementM2cList} owner={owner} {...this.props} />,
 
      serviceInsuranceForInspectionList:  
        <ServiceInsuranceForInspectionViewTable data={serviceInsuranceForInspectionList} owner={owner} {...this.props} />,
 
      serviceVehicleInspectionList:  
        <ServiceVehicleInspectionViewTable data={serviceVehicleInspectionList} owner={owner} {...this.props} />,
 
      serviceFileInspectionList:  
        <ServiceFileInspectionViewTable data={serviceFileInspectionList} owner={owner} {...this.props} />,
 
      serviceVehicleRepairingList:  
        <ServiceVehicleRepairingViewTable data={serviceVehicleRepairingList} owner={owner} {...this.props} />,
 
    
    };
    

    const actionDescForQualification = (vehicleServiceCompanyEmployee) =>{
      if(!vehicleServiceCompanyEmployee){
        return (<div>vehicleServiceCompanyEmployee is not defined</div>)
      }
      const {qualification}=vehicleServiceCompanyEmployee;
      if(!qualification){
        return (<div></div>)
      }
      
      return (

    
      <DescriptionList className={styles.headerList} size="small" col="1">

    <Description term="序号">{qualification.id}</Description> 
    <Description term="时间">{qualification.eventTime}</Description> 
    <Description term="谁">{qualification.who}</Description> 
    <Description term="评论">{qualification.comment}</Description> 
    
            
          </DescriptionList>
      )
    }
    const actionDescForServing = (vehicleServiceCompanyEmployee) =>{
      if(!vehicleServiceCompanyEmployee){
        return (<div>vehicleServiceCompanyEmployee is not defined</div>)
      }
      const {serving}=vehicleServiceCompanyEmployee;
      if(!serving){
        return (<div>serving is not defined</div>)
      }
      
      return (

    
      <DescriptionList className={styles.headerList} size="small" col="1">

    <Description term="序号">{serving.id}</Description> 
    <Description term="时间">{serving.eventTime}</Description> 
    <Description term="谁">{serving.who}</Description> 
    <Description term="评论">{serving.comment}</Description> 
    
            
          </DescriptionList>
      )
    }

    const actionDescForTermination= (vehicleServiceCompanyEmployee) =>{
      if(!vehicleServiceCompanyEmployee){
        return (<div>vehicleServiceCompanyEmployee is not defined</div>)
      }
      const {termination}=vehicleServiceCompanyEmployee;
      if(!termination){
        return (<div>serving is not defined</div>)
      }
      
      return (

    
      <DescriptionList className={styles.headerList} size="small" col="1">

    <Description term="序号">{termination.id}</Description> 
    <Description term="时间">{termination.eventTime}</Description> 
    <Description term="谁">{termination.who}</Description> 
    <Description term="评论">{termination.comment}</Description> 
    
            
          </DescriptionList>
      )
    }

	const steps=(<Steps direction={'horizontal'}  current={1}>
			<Step title="资格" description={actionDescForQualification(this.props.vehicleServiceCompanyEmployee)} />
			<Step title="服务" description={actionDescForServing(this.props.vehicleServiceCompanyEmployee)}/>
			<Step title="终止" description={actionDescForTermination(this.props.vehicleServiceCompanyEmployee)} />
		</Steps>)

    
    
    
    
    return (

      <PageHeaderLayout
        title="服务提供商员工管理总览"
        content={summaryOf(this.props.vehicleServiceCompanyEmployee)}
        wrapperClassName={styles.advancedForm}
      >
	<Card title="流程进度" style={{ marginBottom: 24 }} bordered={false}>{steps}
		</Card>

      
      
	<Card 
  		className={styles.card} 
  		bordered={false}
  		tabList={tabList}
  		onTabChange={this.onTabChange}>
            {contentList[this.state.tabKey]}
        </Card>

 
      </PageHeaderLayout>
    )
  }
}
