import { GithubOutlined } from '@ant-design/icons';
import { DefaultFooter } from '@ant-design/pro-components';
import { useIntl } from 'umi';

const Footer: React.FC = () => {

  const currentYear = new Date().getFullYear();

  return (
    <DefaultFooter
      copyright={`${currentYear} ${"Produced by Haifeng Xiao and Chuanlong Liu"}`} 
      links={[
        {
          key: 'Online Mall',
          title: 'Online Mall',
          href: 'https://pro.ant.design',
          blankTarget: true,
        },
        {
          key: 'github',
          title: <GithubOutlined />,
          href: 'https://github.com/HaifengXiao-29/onlineMall',
          blankTarget: true,
        },
        {
          key: 'Online Mall',
          title: 'Online Mall',
          href: 'https://ant.design',
          blankTarget: true,
        },
      ]}
    />
  );
};

export default Footer;
