

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './EmployeeBoarding.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (employeeBoarding,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{employeeBoarding.id}</Description> 
<Description term="谁">{employeeBoarding.who}</Description> 
<Description term="使用时间">{ moment(employeeBoarding.employTime).format('YYYY-MM-DD')}</Description> 
<Description term="评论">{employeeBoarding.comments}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = employeeBoarding => {
  const {EmployeeBoardingBase} = GlobalComponents
  return <PermissionSetting targetObject={employeeBoarding}  targetObjectMeta={EmployeeBoardingBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class EmployeeBoardingPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  employeeBoarding = this.props.employeeBoarding;
    const { id,displayName, employeeCount } = employeeBoarding
    const cardsData = {cardsName:"员工入职",cardsFor: "employeeBoarding",cardsSource: employeeBoarding,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  employeeBoarding: state._employeeBoarding,
}))(Form.create()(EmployeeBoardingPermission))

