

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
import styles from './EmployeeWorkExperience.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (employeeWorkExperience,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{employeeWorkExperience.id}</Description> 
<Description term="Start">{ moment(employeeWorkExperience.start).format('YYYY-MM-DD')}</Description> 
<Description term="End">{ moment(employeeWorkExperience.end).format('YYYY-MM-DD')}</Description> 
<Description term="Company">{employeeWorkExperience.company}</Description> 
<Description term="Description">{employeeWorkExperience.description}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = employeeWorkExperience => {
  const {EmployeeWorkExperienceBase} = GlobalComponents
  return <PermissionSetting targetObject={employeeWorkExperience}  targetObjectMeta={EmployeeWorkExperienceBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class EmployeeWorkExperiencePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  employeeWorkExperience = this.props.employeeWorkExperience;
    const { id,displayName,  } = employeeWorkExperience
    const cardsData = {cardsName:"Employee Work Experience",cardsFor: "employeeWorkExperience",cardsSource: employeeWorkExperience,
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
  employeeWorkExperience: state._employeeWorkExperience,
}))(Form.create()(EmployeeWorkExperiencePermission))

