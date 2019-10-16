

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
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

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (employeeWorkExperience,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{employeeWorkExperience.id}</Description> 
<Description term="开始">{ moment(employeeWorkExperience.start).format('YYYY-MM-DD')}</Description> 
<Description term="结束">{ moment(employeeWorkExperience.end).format('YYYY-MM-DD')}</Description> 
<Description term="公司">{employeeWorkExperience.company}</Description> 
<Description term="描述">{employeeWorkExperience.description}</Description> 
	
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
    const  employeeWorkExperience = this.props.employeeWorkExperience
    const { id,displayName,  } = employeeWorkExperience
    const  returnURL = `/employeeWorkExperience/${id}/dashboard`
    const cardsData = {cardsName:"员工工作经验",cardsFor: "employeeWorkExperience",cardsSource: employeeWorkExperience,displayName,returnURL,
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
  employeeWorkExperience: state._employeeWorkExperience,
}))(Form.create()(EmployeeWorkExperiencePermission))

