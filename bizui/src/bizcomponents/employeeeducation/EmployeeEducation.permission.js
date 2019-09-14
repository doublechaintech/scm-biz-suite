

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './EmployeeEducation.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (employeeEducation,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{employeeEducation.id}</Description> 
<Description term="完成时间">{ moment(employeeEducation.completeTime).format('YYYY-MM-DD')}</Description> 
<Description term="类型">{employeeEducation.type}</Description> 
<Description term="备注">{employeeEducation.remark}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = employeeEducation => {
  const {EmployeeEducationBase} = GlobalComponents
  return <PermissionSetting targetObject={employeeEducation}  targetObjectMeta={EmployeeEducationBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class EmployeeEducationPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  employeeEducation = this.props.employeeEducation
    const { id,displayName,  } = employeeEducation
    const  returnURL = `/employeeEducation/${id}/dashboard`
    const cardsData = {cardsName:"员工教育",cardsFor: "employeeEducation",cardsSource: employeeEducation,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
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
  employeeEducation: state._employeeEducation,
}))(Form.create()(EmployeeEducationPermission))

