

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
import styles from './EmployeeEducation.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (employeeEducation,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{employeeEducation.id}</Description> 
<Description term="Complete Time">{ moment(employeeEducation.completeTime).format('YYYY-MM-DD')}</Description> 
<Description term="Type">{employeeEducation.type}</Description> 
<Description term="Remark">{employeeEducation.remark}</Description> 
	
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
    const  employeeEducation = this.props.employeeEducation;
    const { id,displayName,  } = employeeEducation
    const cardsData = {cardsName:"Employee Education",cardsFor: "employeeEducation",cardsSource: employeeEducation,
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
  employeeEducation: state._employeeEducation,
}))(Form.create()(EmployeeEducationPermission))

